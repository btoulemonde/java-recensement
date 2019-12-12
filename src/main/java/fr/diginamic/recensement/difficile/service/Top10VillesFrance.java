package fr.diginamic.recensement.difficile.service;

import java.util.Scanner;
import fr.diginamic.recensement.facile.Ville;
import fr.diginamic.recensement.difficile.Recensement;
import fr.diginamic.recensement.difficile.service.comparator.Top10VilleComparator;

import java.util.Collections;
import java.util.List;

public class Top10VillesFrance {
	
	Scanner scanner = new Scanner (System.in);
	
	public void traiter(Recensement recensement, Scanner scanner){
		List<Ville> villes = recensement.getVilles();
		
		Collections.sort(villes, new Top10VilleComparator());
		for (int i =0; i<10; i++){
			System.out.println(villes.get(i));
		}
			
		}
}
