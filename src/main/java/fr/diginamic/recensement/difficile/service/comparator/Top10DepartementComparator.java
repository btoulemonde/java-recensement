package fr.diginamic.recensement.difficile.service.comparator;

import java.util.Comparator;

import fr.diginamic.recensement.facile.Departement;

public class Top10DepartementComparator implements Comparator<Departement> {

	@Override
	public int compare(Departement d1, Departement d2) {
		if (d1.getPopulation() < d2.getPopulation()) {
			return 1;
		} else if (d1.getPopulation() > d2.getPopulation()) {
			return -1;
		}
		return 0;
	}

}
