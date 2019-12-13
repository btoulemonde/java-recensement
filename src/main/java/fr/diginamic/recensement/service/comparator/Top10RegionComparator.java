package fr.diginamic.recensement.difficile.service.comparator;

import java.util.Comparator;

import fr.diginamic.recensement.facile.Region;

public class Top10RegionComparator implements Comparator<Region> {

	@Override
	public int compare(Region r1, Region r2) {
		if (r1.getPopulation() < r2.getPopulation()) {
			return 1;
		} else if (r1.getPopulation() > r2.getPopulation()) {
			return -1;
		}
		return 0;
	}

}
