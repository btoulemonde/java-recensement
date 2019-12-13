package fr.diginamic.recensement.service;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.service.comparator.Top10VilleComparator;
import fr.diginamic.recensement.utils.Recensement;

public class Top10VillesDepartement {

	Scanner scanner = new Scanner(System.in);

	public void traiter(Recensement recensement, Scanner scanner) {
		List<Ville> villes = recensement.getVilles();
		List<Ville> villesDepartement = new ArrayList<>();
		System.out.println("Veuillez saisir le code du département : ");
		String choix = scanner.next();

		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equals(choix)) {
				villesDepartement.add(ville);
			}
		}
		Collections.sort(villesDepartement, new Top10VilleComparator());
		for (int i = 0; i < 10; i++) {
			System.out.println(villesDepartement.get(i));
		}

	}
}
