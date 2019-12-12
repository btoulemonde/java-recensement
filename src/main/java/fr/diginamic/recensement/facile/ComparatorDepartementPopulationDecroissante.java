package fr.diginamic.recensement.facile;

import java.util.Comparator;

public class ComparatorDepartementPopulationDecroissante implements Comparator<Departement> {

	@Override
	public int compare(Departement d1, Departement d2) {
		if (d1.getPopulation()<d2.getPopulation()){
			return 1;
		}else if(d1.getPopulation()>d2.getPopulation()){
			return -1;
		}
		return 0;
	}

}
