package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.Connect;

public class DepartementDaoJdbc implements DepartementDao {

	private PreparedStatement statement;
	private static Connection connexion;
	private ResultSet result;

	public DepartementDaoJdbc() {
		connexion = Connect.getConnection();
		
	}

	/* (non-Javadoc)
	 * @see fr.diginamic.recensement.dao.DepartementDao#extraire()
	 */
	@Override
	public List<Departement> extraire() {
		int population = 0;
		List<Departement> departements = new ArrayList<>();
		result = Connect.select(
				"SELECT DEPARTEMENT.CODE_DEPARTEMENT, SUM(POPULATION) FROM DEPARTEMENT, VILLE WHERE DEPARTEMENT.CODE_DEPARTEMENT = VILLE.CODE_DEPARTEMENT GROUP BY CODE_DEPARTEMENT ORDER BY SUM(POPULATION)DESC ");

		try {
			while (result.next()) {
				population = result.getInt("SUM(POPULATION)");
				String codeDpt = result.getString("CODE_DEPARTEMENT");
				Departement departement = new Departement(codeDpt, population);
				departements.add(departement);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return departements;
		
	}
	
	@Override
	public List<Ville> topVille(String codeDpt){
		List<Ville> villes = new ArrayList<>();
		result = Connect.select("SELECT * FROM VILLE WHERE CODE_DEPARTEMENT = '"+ codeDpt + "' ORDER BY POPULATION DESC");
		
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

	/**
	 * Méthode pour tester si le département est déja dans la database
	 * 
	 * @param ville
	 *            : liste des villes de type List
	 * @return retourne un booléen
	 */
	public boolean exist(Ville ville) {
		boolean next = false;

		result = Connect.select("SELECT CODE_DEPARTEMENT FROM DEPARTEMENT WHERE CODE_DEPARTEMENT ='"
				+ ville.getCodeDepartement().toUpperCase() + "'");

		try {
			next = result.next();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return next;
	}

	@Override
	public void insert(List<Ville> villes) {

		try {
			for (Ville ville : villes) {
				if (exist(ville) == false) {
					statement = connexion
							.prepareStatement("INSERT INTO DEPARTEMENT(CODE_DEPARTEMENT, CODE_REGION) VALUES(?,?)");

					statement.setString(1, ville.getCodeDepartement());
					statement.setInt(2, Integer.parseInt(ville.getCodeRegion()));

					statement.executeUpdate();
				}
			}
		} catch (SQLException e) {
			System.out.println("echec de l'ajout");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public int update(String designation, String nouveauPrix) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int populationDep(String codeDepartement) {
		int population = 0;
		result = Connect
				.select("SELECT DEPARTEMENT.CODE_DEPARTEMENT, SUM(POPULATION) FROM DEPARTEMENT, VILLE WHERE DEPARTEMENT.CODE_DEPARTEMENT = VILLE.CODE_DEPARTEMENT GROUP BY CODE_DEPARTEMENT HAVING CODE_DEPARTEMENT = '"
						+ codeDepartement + "'");
		try {
			while (result.next()) {
				population = result.getInt("SUM(POPULATION)");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return population;
	}

}
