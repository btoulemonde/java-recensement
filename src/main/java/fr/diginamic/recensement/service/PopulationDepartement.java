package fr.diginamic.recensement.service;


import java.util.Scanner;
import fr.diginamic.recensement.dao.DepartementDaoJdbc;

public class PopulationDepartement {
	

Scanner scanner = new Scanner(System.in);
	
	/**méthode statique permettant de selectionner la population d'un département dont l'utilsateur saisie le code
	 * @param scanner
	 */
	public static void traiter(Scanner scanner){
		
		System.out.println("Veuillez saisir le numéro de département : ");
		String choix = scanner.next();
		
		DepartementDaoJdbc departementDao = new DepartementDaoJdbc();
		int populationDep = departementDao.populationDep(choix);
		System.out.println("la population du département "+choix+" est de " + populationDep + " habitants");
	}

}
