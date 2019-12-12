package fr.diginamic.recensement.difficile.service;


import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.difficile.Recensement;
import fr.diginamic.recensement.facile.Ville;

public class PopulationRegion {
	Scanner scanner = new Scanner(System.in);
	
	public void traiter (Recensement recensement, Scanner scanner){
		
		System.out.println("veuillez saisir une Région");
		String choix = scanner.next();
		List<Ville> villes= recensement.getVilles();
		
		int populationRegion = 0;
		for (Ville ville : villes){
			if(ville.getNomRegion().equalsIgnoreCase(choix)){
				populationRegion += ville.getPopulation();
			}
		}
		
		System.out.println("la population de la région choisie est de " + populationRegion + " habitants");

	}

}
