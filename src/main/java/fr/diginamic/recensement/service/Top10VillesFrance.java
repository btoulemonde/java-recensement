package fr.diginamic.recensement.service;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.service.comparator.Top10VilleComparator;
import fr.diginamic.recensement.utils.Recensement;

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
