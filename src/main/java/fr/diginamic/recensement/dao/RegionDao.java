package fr.diginamic.recensement.dao;

import java.util.List;

import fr.diginamic.recensement.entites.Region;
import fr.diginamic.recensement.entites.Ville;

public interface RegionDao {
	/**Méthode permettant d'extraire une liste des régions
	 * @return retoutne une liste des régions
	 */
	List<Region> extraire();
	
	/**méthode pour insérer toutes les régions vers la base de donnée.
	 * @param List<Ville> : liste des régions
	 */
	void insert(List<Ville> villes);
	
	
	/**Méthode permettant de retourner la population d'une région 
	 * @param codeRegion de type int
	 * @return int 
	 */
	public int populationRegion (int codeRegion) ;
	
	/**Méthode permettant de crééer une liste des villes avec la population triée par ordre décroissant
	 * @param nomReg nom de la région voulue
	 * @return List liste de s villes de la région
	 */
	public List<Ville> topVille(String nomReg);

}
