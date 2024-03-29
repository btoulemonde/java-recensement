package fr.diginamic.recensement.service;

import java.util.List;
import fr.diginamic.recensement.dao.DepartementDaoJdbc;
import fr.diginamic.recensement.entites.Departement;

/** classe permettant d'appler la méthode extraire 
 * @author bapti
 *
 */
public class Top10DepartementPopulation {
	/**
	 * méthode permettant d'afficher les 10 départements les plus peuplés de France.
	 */
	public static void traiter() { 
		System.out.println("Les 10 départements les plus peuplés de France sont : ");

		DepartementDaoJdbc departementDao = new DepartementDaoJdbc();
		List<Departement> departements = departementDao.extraire();
		for (int i = 0; i < 10; i++) {

			System.out.println(departements.get(i));
		}
	}
}
