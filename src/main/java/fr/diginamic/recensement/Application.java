package fr.diginamic.recensement;

import java.util.Scanner;

import fr.diginamic.recensement.service.PopulationDepartement;
import fr.diginamic.recensement.service.PopulationRegion;
import fr.diginamic.recensement.service.PopulationVille;
import fr.diginamic.recensement.service.Top10DepartementPopulation;
import fr.diginamic.recensement.service.Top10RégionPopulation;
import fr.diginamic.recensement.service.Top10VillesDepartement;
import fr.diginamic.recensement.service.Top10VillesFrance;
import fr.diginamic.recensement.service.Top10VillesRegion;
import fr.diginamic.recensement.utils.Connect;
import fr.diginamic.recensement.utils.ValeurNul;

public class Application {

	public static void main(String[] args) throws ValeurNul {
		
		Scanner scanner = new Scanner(System.in);
		int choix = 0;
		do {
			System.out.println(" ------------------MENU----------------------");
			System.out.println("1: Afficher la population d'une ville");
			System.out.println("2: Afficher la population d'un département");
			System.out.println("3: Afficher la population d'une Région");
			System.out.println("4: Afficher les 10 régions les plus peuplées");
			System.out.println("5: Afficher les 10 départements les plus peuplés");
			System.out.println("6: Afficher les 10 villes les plus peuplées d'un département ");
			System.out.println("7: Afficher les 10 villes les plus peuplées d'une région");
			System.out.println("8: Afficher les 10 villes les plus peuplées de France");
			System.out.println("9: Sortir");
			String choixUser = scanner.next();
			choix = Integer.parseInt(choixUser);

			switch (choix) {
			case 1:
				PopulationVille.traiter(scanner);
				break;
			case 2:
				PopulationDepartement.traiter(scanner);
				break;
			case 3:
				PopulationRegion.traiter(choix);
				break;
			case 4:
				Top10RégionPopulation.traiter();
				break;
			case 5:
				Top10DepartementPopulation.traiter();
				break;
			case 6:
				Top10VillesDepartement.traiter(scanner);
				break;
			case 7:
				Top10VillesRegion.traiter(scanner);
				break;
			case 8:
				Top10VillesFrance.traiter();
				break;
			}
		}	while (choix != 9);
		Connect.connexionClose();
	}
}
