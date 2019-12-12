package fr.diginamic.recensement.difficile;

import java.util.Scanner;

import fr.diginamic.recensement.difficile.service.PopulationDepartement;
import fr.diginamic.recensement.difficile.service.PopulationRegion;
import fr.diginamic.recensement.difficile.service.PopulationVille;
import fr.diginamic.recensement.difficile.service.Top10DepartementPopulation;
import fr.diginamic.recensement.difficile.service.Top10RégionPopulation;
import fr.diginamic.recensement.difficile.service.Top10VillesDepartement;
import fr.diginamic.recensement.difficile.service.Top10VillesFrance;
import fr.diginamic.recensement.difficile.service.Top10VillesRegion;
import fr.diginamic.recensement.difficile.LectureFichier;

public class Application {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Recensement recensement = LectureFichier.lire("C:/work/recensement population 2016.csv");
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
			String choixUser = scanner.nextLine();
			choix = Integer.parseInt(choixUser);

			switch (choix) {
			case 1:
				PopulationVille populationVille = new PopulationVille();
				populationVille.traiter(recensement, scanner);
				break;
			case 2:
				PopulationDepartement populationDepartement = new PopulationDepartement();
				populationDepartement.traiter(recensement, scanner);
				break;
			case 3:
				PopulationRegion populationRegion = new PopulationRegion();
				populationRegion.traiter(recensement, scanner);
				break;
			case 4:
				Top10RégionPopulation top10Region = new Top10RégionPopulation();
				top10Region.traiter(recensement);
				break;
			case 5:
				Top10DepartementPopulation top10Departement = new Top10DepartementPopulation();
				top10Departement.traiter(recensement);
				break;
			case 6:
				Top10VillesDepartement top10VillesDepartement = new Top10VillesDepartement();
				top10VillesDepartement.traiter(recensement, scanner);
				break;
			case 7:
				Top10VillesRegion top10VillesRegion = new Top10VillesRegion();
				top10VillesRegion.traiter(recensement, scanner);
				break;
			case 8:
				Top10VillesFrance top10VillesFrance = new Top10VillesFrance();
				top10VillesFrance.traiter(recensement, scanner);
				break;
			}
		}	while (choix != 9);
	}
}
