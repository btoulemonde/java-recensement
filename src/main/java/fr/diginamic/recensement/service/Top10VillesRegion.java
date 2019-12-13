package fr.diginamic.recensement.service;

import java.util.List;
import java.util.Scanner;
import fr.diginamic.recensement.dao.RegionDaoJdbc;
import fr.diginamic.recensement.entites.Ville;

public class Top10VillesRegion {

	Scanner scanner = new Scanner(System.in);

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

