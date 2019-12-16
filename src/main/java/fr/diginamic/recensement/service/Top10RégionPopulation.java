package fr.diginamic.recensement.service;

import java.util.List;
import fr.diginamic.recensement.dao.RegionDaoJdbc;
import fr.diginamic.recensement.entites.Region;

/**classe permettant d'appeler la méthode extraire
 * @author bapti
 *
 */
public class Top10RégionPopulation {

	/**
	 * Méthode permettant d'afficher les 10 régions les plus peuplées de France.
	 */
	public static void traiter() {
		System.out.println("Les 10 régions les plus peuplées de France sont : ");
		RegionDaoJdbc regionDao = new RegionDaoJdbc();
		List<Region> regions = regionDao.extraire();
		
		for (int i = 0; i < 10; i++) {

			System.out.println(regions.get(i));
		}
	}
}
