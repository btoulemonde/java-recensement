package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.Connect;

public class VilleDaoJdbc implements VilleDao {
	private PreparedStatement statement;
	private ResultSet result;
	private static Connection connexion;

	public VilleDaoJdbc() {
		connexion = Connect.getConnection();
	}


	/* (non-Javadoc)
	 * @see fr.diginamic.recensement.dao.VilleDao#insert(java.util.List)
	 */
	@Override
	public void insert(List<Ville> villes) {
		try {

			for (Ville ville : villes) {
				statement = connexion.prepareStatement(
						"INSERT INTO VILLE(NOM_VILLE, CODE_REGION, CODE_DEPARTEMENT, POPULATION) VALUES(?,?,?,?)");
				statement.setString(1, ville.getNomCommune());
				statement.setInt(2, Integer.parseInt(ville.getCodeRegion()));
				statement.setString(3, ville.getCodeDepartement());
				statement.setInt(4, ville.getPopulation());

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("echec de l'ajout");
			System.out.println(e.getMessage());;
		}
	}

	
	/* (non-Javadoc)
	 * @see fr.diginamic.recensement.dao.VilleDao#topVille()
	 */
	@Override
	public List<Ville> topVille(){
		
		List<Ville> villes = new ArrayList<>();
		result = Connect.select("SELECT * FROM VILLE ORDER BY POPULATION DESC");
		
		try {
			while(result.next()){
				int population = result.getInt("POPULATION");
				String nom = result.getString("NOM_Ville");
				Ville ville = new Ville( nom, population);
				villes.add(ville);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return villes;
	}



	@Override
	public int populationVille(String ville) {
		int populationVille = 0;
		result = Connect.select("SELECT * FROM VILLE WHERE NOM_VILLE=+'" + ville + "'");
		try {
			while(result.next()){
				populationVille = result.getInt("POPULATION");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		return populationVille;
	}

}
