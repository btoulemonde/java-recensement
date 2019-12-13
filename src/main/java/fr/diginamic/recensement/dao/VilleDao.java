package fr.diginamic.recensement.dao;

import java.util.List;

import fr.diginamic.recensement.entites.Ville;

public interface VilleDao {
	
	
	/**méthode pour insérer toutes les villes vers la base de donnée.
	 * @param List<Ville> : liste des villes
	 */
	void insert(List<Ville> villes);
	
	
	/**Méthode permettant d'extraire la population d'une ville
	 * @param ville de type String
	 * @return la population de type int
	 */
	int populationVille(String ville);
	
	/**Méthoded permettant de classer les villes de France par ordre decroissant de popualtion
	 * @return liste de ville classées
	 */
	public List<Ville> topVille();

}
