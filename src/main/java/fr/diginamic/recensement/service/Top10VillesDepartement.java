package fr.diginamic.recensement.service;

import java.util.Scanner;
import java.util.List;
import fr.diginamic.recensement.dao.DepartementDaoJdbc;
import fr.diginamic.recensement.entites.Ville;
/**classe permettant d'appeler la méthode topVille pour un département saisi par l'utilisateur
 * @author bapti
 *
 */
public class Top10VillesDepartement {


	/**Méthode permettant d'afficher les 10 villes les plus peuplées d'un département saisie par l'utilisateur
	 * l'utilisateur doit saisir le code du département
	 * @param scanner
	 */
	public static void traiter( Scanner scanner) {
		System.out.println("Veuillez saisir le code du département : ");
		String choix = scanner.next();
		DepartementDaoJdbc departementDao = new DepartementDaoJdbc();
		List<Ville> villes = departementDao.topVille(choix);
		
		for (int i = 0; i < 10; i++) {
			System.out.println(villes.get(i));
		}
	}
}
