package fr.diginamic.recensement.difficile.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import fr.diginamic.recensement.difficile.service.comparator.Top10RegionComparator;
import fr.diginamic.recensement.difficile.Recensement;
import fr.diginamic.recensement.facile.Region;
import fr.diginamic.recensement.facile.Ville;

public class Top10RégionPopulation {

	public void traiter(Recensement recensement) {
		System.out.println("Les 10 régions les plus peuplées de France sont : ");

		HashMap<String, Region> mapRegion = new HashMap<>();
		List<Ville> villes = recensement.getVilles();
		for (Ville ville : villes) {

			Region region = mapRegion.get(ville.getNomRegion());

			// creation si elle nexiste pas encore
			if (region == null) {
				region = new Region(ville.getNomRegion());
				mapRegion.put(ville.getNomRegion(), region);
			}
			region.setPopulation(region.getPopulation() + ville.getPopulation());
		}
		ArrayList<Region> listeRegion = new ArrayList<>();
		listeRegion.addAll(mapRegion.values());

		Collections.sort(listeRegion, new Top10RegionComparator());
		for (int i = 0; i < 10; i++) {

			System.out.println(listeRegion.get(i));
		}

	}
}
