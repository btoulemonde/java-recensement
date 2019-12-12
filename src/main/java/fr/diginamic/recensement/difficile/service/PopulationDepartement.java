package fr.diginamic.recensement.difficile.service;


import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.difficile.Recensement;
import fr.diginamic.recensement.facile.Ville;

public class PopulationDepartement {
	
Scanner scanner = new Scanner(System.in);
	
	public void traiter(Recensement recensement, Scanner scanner){
		
		System.out.println("Veuillez saisir le numéro de département : ");
		String choix = scanner.next();
		
		List<Ville> villes = recensement.getVilles();
		int populationDepartement = 0;
		for (Ville ville : villes){
			if (ville.getCodeDepartement().equals(choix)){
				populationDepartement += ville.getPopulation();
				
			}
		}
		System.out.println("la population du département choisi est de " + populationDepartement + " habitants");
	}

}
