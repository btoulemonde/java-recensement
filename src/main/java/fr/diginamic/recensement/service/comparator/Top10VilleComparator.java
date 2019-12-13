package fr.diginamic.recensement.difficile.service.comparator;

import java.util.Comparator;

import fr.diginamic.recensement.facile.Ville;

public class Top10VilleComparator implements Comparator<Ville> {

	@Override
	public int compare(Ville v1, Ville v2) {
		if (v1.getPopulation()<v2.getPopulation()){
			return 1;
		}else if (v1.getPopulation()>v2.getPopulation()){
			return -1;
		}
		return 0;
	}

}
