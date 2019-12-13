package fr.diginamic.recensement.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.service.comparator.Top10VilleComparator;
import fr.diginamic.recensement.utils.Recensement;

public class Top10VillesRegion {

	Scanner scanner = new Scanner(System.in);

	public void traiter(Recensement recensement, Scanner scanner) {
		List<Ville> villes = recensement.getVilles();
		List<Ville> villesRegion = new ArrayList<>();
		System.out.println("Veuillez saisir le nom d'une région : ");
		String choix = scanner.next();

		for (Ville ville : villes) {
			if (ville.getNomRegion().equalsIgnoreCase(choix)) {
				villesRegion.add(ville);
			}
		}
		Collections.sort(villesRegion, new Top10VilleComparator());
		for (int i = 0; i < 10; i++) {
			System.out.println(villesRegion.get(i));
		}

	}
}

