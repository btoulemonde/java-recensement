package fr.diginamic.recensement.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import fr.diginamic.recensement.dao.RegionDaoJdbc;
import fr.diginamic.recensement.utils.Connect;

/** Classe permettant d'appler la méthode populationRegion et de demander à l'utilisateur de saisir 
 * @author bapti
 *
 */
public class PopulationRegion {
	
	/**méthode permetant de selectionner  la population d'une région choisie par l'utilisateur
	 * l'utilisateur doit saisir le nom de la région
	 * @param choix
	 */
	public static void traiter ( Scanner scanner){
		int choix = 0;
		System.out.println("veuillez saisir un code région");
		String choixUser = scanner.next();
		choix = Integer.parseInt(choixUser);
		RegionDaoJdbc regionDao = new RegionDaoJdbc();
		
		int populationRegion = regionDao.populationRegion(choix);
		
		ResultSet result = Connect.select("Select NOM_REGION FROM REGION WHERE CODE_REGION =" + choix);
		String nomRegion = null;
		try {
			while(result.next()){
				nomRegion = result.getString("NOM_REGION");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("la population de la région "+ nomRegion +"  est de " + populationRegion + " habitants");
	}

}
