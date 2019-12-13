package fr.diginamic.recensement.service;

import java.util.Scanner;
import fr.diginamic.recensement.dao.VilleDaoJdbc;
import fr.diginamic.recensement.entites.Ville;
import java.util.List;

public class Top10VillesFrance {
	
	Scanner scanner = new Scanner (System.in);
	
	/**
	 * Méthode statique permettant d'afficher les 10 pplus grandes villes de France.
	 */
	public static void traiter(){
		
		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		List<Ville> villes = villeDao.topVille();
		for (int i =0; i<10; i++){
			System.out.println(villes.get(i));
		}
			
		}
}
