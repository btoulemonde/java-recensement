package fr.diginamic.recensement.service;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.utils.Recensement;

public class PopulationVille {
	Scanner scanner = new Scanner(System.in);
	
	public void traiter(Recensement recensement, Scanner scanner){
		System.out.println("veuillez saisir la ville : ");
		String choix = scanner.nextLine();
		
		List<Ville> villes = recensement.getVilles();
		for (Ville ville : villes){
			if (ville.getNomCommune().equalsIgnoreCase(choix)){
				System.out.println(ville.getNomCommune() + " a " + ville.getPopulation() + " habitants");
			}
		}
		
	}
	
	

}
