package fr.diginamic.recensement.service;

import java.util.Scanner;
import java.util.List;
import fr.diginamic.recensement.dao.DepartementDaoJdbc;
import fr.diginamic.recensement.entites.Ville;

public class Top10VillesDepartement {

	Scanner scanner = new Scanner(System.in);

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
