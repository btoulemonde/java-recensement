package fr.diginamic.recensement.facile;

import java.util.Comparator;

public class ComparatorRegionPopulationDecroissante implements Comparator<Region> {

	@Override
	public int compare(Region r1, Region r2) {
		if (r1.getPopulation()<r2.getPopulation()){
			return 1;
		}else if(r1.getPopulation()>r2.getPopulation()){
			return -1;
		}
		return 0;
	}

}
