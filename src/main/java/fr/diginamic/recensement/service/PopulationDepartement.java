package fr.diginamic.recensement.service;


import java.util.Scanner;
import fr.diginamic.recensement.dao.DepartementDaoJdbc;
import fr.diginamic.recensement.utils.ValeurNul;

public class PopulationDepartement {
	

Scanner scanner = new Scanner(System.in);
	
	/**méthode statique permettant de selectionner la population d'un département dont l'utilsateur saisie le code
	 * @param scanner
	 * @throws ValeurNul 
	 */
	public static void traiter(Scanner scanner){
		
		System.out.println("Veuillez saisir le numéro de département : ");
		String choix = scanner.next();
		
		DepartementDaoJdbc departementDao = new DepartementDaoJdbc();
		int populationDep;
			
			populationDep = departementDao.populationDep(choix);
			if(populationDep ==0){
				try {
					throw new ValeurNul("la valeur saisie n'est pas valide");
				} catch (ValeurNul e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("la population du département "+choix+" est de " + populationDep + " habitants");
		
	}
	
}
