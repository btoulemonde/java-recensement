package fr.diginamic.recensement.service;

import fr.diginamic.recensement.dao.VilleDaoJdbc;
import fr.diginamic.recensement.entites.Ville;

import java.util.List;

/**classe permettant d'appeler la méthode topVille
 * @author bapti
 *
 */
public class Top10VillesFrance {


	/**
	 * Méthode statique permettant d'afficher les 10 plus grandes villes de
	 * France.
	 */
	public static void traiter() {

		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		List<Ville> villes = villeDao.topVille();
		for (int i = 0; i < 10; i++) {
			System.out.println(villes.get(i));
		}

	}
}
