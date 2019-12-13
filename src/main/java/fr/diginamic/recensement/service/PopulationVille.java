package fr.diginamic.recensement.service;

import java.util.Scanner;
import fr.diginamic.recensement.dao.VilleDaoJdbc;

public class PopulationVille {
	Scanner scanner = new Scanner(System.in);
	
	/**méthode statique permettant d'afficher la population d'une ville saisie par l'utilisateur
	 * @param scanner
	 */
	public static void traiter(Scanner scanner){
		System.out.println("veuillez saisir la ville : ");
		String choix = scanner.nextLine();
		
		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		int populationVille = villeDao.populationVille(choix);
		
		System.out.println("la population de "+ choix +"  est de " + populationVille + " habitants");

		
			}
	}
	
