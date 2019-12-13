package fr.diginamic.recensement.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.service.comparator.Top10DepartementComparator;
import fr.diginamic.recensement.utils.Recensement;

public class Top10DepartementPopulation {
	public void traiter(Recensement recensement) {
		System.out.println("Les 10 départements les plus peuplés de France sont : ");

		HashMap<String, Departement> mapDepartement = new HashMap<>();
		List<Ville> villes = recensement.getVilles();
		for (Ville ville : villes) {

			Departement departement = mapDepartement.get(ville.getCodeDepartement());

			// creation si elle nexiste pas encore
			if (departement == null) {
				departement = new Departement(ville.getCodeDepartement());
				mapDepartement.put(ville.getCodeDepartement(), departement);
			}
			departement.setPopulation(departement.getPopulation() + ville.getPopulation());
		}
		ArrayList<Departement> listeDepartement = new ArrayList<>();
		listeDepartement.addAll(mapDepartement.values());

		Collections.sort(listeDepartement, new Top10DepartementComparator());
		for (int i = 0; i < 10; i++) {

			System.out.println(listeDepartement.get(i));
		}

	}
}
