package fr.diginamic.recensement.utils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;

public class ParseurVille {

	/**méthode pour spliter les lignes afin de récupérer les morceaux qui nous intérèsse pour exploiter les données de recensement.
	 * @param recensement
	 * @param ligne
	 */
	public static void ajoutLigne(Recensement recensement, String ligne) {
		
		// On commence par découper la ligne en morceaux sur la base du caractère séparateur « ; » . De plus on ne récupère que les morceaux qui nous intéressent. En l’occurrence on ignore les morceaux 3 et 4 dont on a pas besoin dans le TP
		String[] morceaux = ligne.split(";");
		String codeRegion = morceaux[0];
		String nomRegion = morceaux[1];
		String codeDepartement = morceaux[2];
		String nomCommune = morceaux[6];
		String population = morceaux[9];
		
		
		// Pour la population, avant la conversion en int, il faut d’abord supprimer les
		// espaces qui se trouvent à l’intérieur.
		int populationTotale = Integer.parseInt(population.replace(" ", "").trim());
		
		
		// On cree maintenant la ville avec toutes ses données utiles
		Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, nomCommune, populationTotale);
		
		//ajout a recensement
		recensement.getVilles().add(ville);

	}

}
