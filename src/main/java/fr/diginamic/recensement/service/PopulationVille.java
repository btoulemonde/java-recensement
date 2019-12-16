package fr.diginamic.recensement.service;

import java.util.Scanner;
import fr.diginamic.recensement.dao.VilleDaoJdbc;

/**Classe poup appler laméthode population ville et demander à l'utilsateur de saisir une ville
 * @author bapti
 *
 */
public class PopulationVille {

	/**
	 * méthode statique permettant d'afficher la population d'une ville saisie
	 * par l'utilisateur
	 * 
	 * @param scanner pour saisir la ville
	 */
	public static void traiter(Scanner scanner) {
		System.out.println("veuillez saisir la ville : ");
		String choix = scanner.next();

		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		int populationVille = villeDao.populationVille(choix);

		System.out.println("la population de " + choix + "  est de " + populationVille + " habitants");

	}
}
