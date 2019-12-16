package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.recensement.entites.Region;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.Connect;

/** implementation de RegionDao
 * @author bapti
 *
 */
public class RegionDaoJdbc implements RegionDao {

	private PreparedStatement statement;
	private ResultSet result;
	private static Connection connexion;
	
	public RegionDaoJdbc() {
		connexion = Connect.getConnection();
		
	}
	@Override
	public void insert(List<Ville> villes) {
		try {
			for (Ville ville : villes) {
				if(exist(ville) == false){
					
				statement = connexion.prepareStatement("INSERT INTO REGION(Code_REGION,NOM_REGION) VALUES(?,?)");

				statement.setInt(1, Integer.parseInt(ville.getCodeRegion()));
				statement.setString(2, ville.getNomRegion());

				statement.executeUpdate();
				}
				
			}
		} catch (SQLException e) {
			System.out.println("echec de l'ajout");
			System.out.println(e.getMessage());
		}
	}
	@Override
	public List<Region> extraire() {
		int population = 0;
		List<Region> regions = new ArrayList<>();
		result = Connect.select(
				"SELECT REGION.NOM_REGION, SUM(POPULATION) FROM REGION, VILLE WHERE REGION.CODE_REGION = VILLE.CODE_REGION GROUP BY REGION.CODE_REGION ORDER BY SUM(POPULATION) DESC ");

		try {
			while (result.next()) {
				population = result.getInt("SUM(POPULATION)");
				String nomRegion = result.getString("NOM_REGION");
				Region region = new  Region(population, nomRegion);
				regions.add(region);

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return regions;
	}
	@Override
	public List<Ville> topVille(String nomReg){
		List<Ville> villes = new ArrayList<>();
		result = Connect.select("SELECT NOM_VILLE,NOM_REGION, POPULATION FROM VILLE,REGION WHERE VILLE.CODE_REGION = REGION.CODE_REGION GROUP BY"
				+ " NOM_VILLE, NOM_REGION, POPULATION HAVING NOM_REGION='"+ nomReg + "' ORDER BY POPULATION DESC");
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
	 * Méthode pour tester si la région est déja dans la database
	 * 
	 * @param ville : liste des villes de type List
	 * @return retourne un booléen
	 */
	public boolean exist(Ville ville) {
		boolean next = false;
		
			result = Connect.select("SELECT CODE_REGION FROM REGION WHERE CODE_REGION =" + ville.getCodeRegion());

				try {
					next = result.next();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		return next;
	}

	

	@Override
	public int populationRegion(int codeRegion) {
		int population = 0;
		result = Connect.select("SELECT REGION.CODE_REGION, SUM(POPULATION) FROM REGION, VILLE WHERE REGION.CODE_REGION = VILLE.CODE_REGION GROUP BY CODE_REGION HAVING CODE_REGION = "+codeRegion+"");
		try {
			while(result.next()){
				population = result.getInt("SUM(POPULATION)");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return population;
	}

}
