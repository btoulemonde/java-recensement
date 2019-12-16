package fr.diginamic.recensement.service;

import java.util.List;
import java.util.Scanner;
import fr.diginamic.recensement.dao.RegionDaoJdbc;
import fr.diginamic.recensement.entites.Ville;

/**classe permettant d'appeler la méthode top Ville et l'appliquer avec une région saisie par l'utilisateur
 * @author bapti
 *
 */
public class Top10VillesRegion {


	/**Méthode statique permettant d'afficher les 10 villes les plus peuplées d'une région saisie par l'utilisateur
	 * l'utilisateur doit saisir le nom de la région
	 * @param scanner
	 */
	public static void traiter(Scanner scanner) {
		System.out.println("Veuillez saisir le nom d'une région : ");
		String choix = scanner.next();
		RegionDaoJdbc regionDao = new RegionDaoJdbc();
		List<Ville> villes = regionDao.topVille(choix);

		for (int i = 0; i < 10; i++) {
			System.out.println(villes.get(i));
		}
	}
}

