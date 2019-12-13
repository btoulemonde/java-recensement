package fr.diginamic.recensement.dao;

import java.util.List;

import fr.diginamic.recensement.entites.Ville;

public interface VilleDao {
	
	/**
	 * @return
	 */
	List<Ville> extraire();
	
	/**méthode pour insérer toutes les villes vers la base de donnée.
	 * @param List<Ville> : liste des villes
	 */
	void insert(List<Ville> villes);
	
	/**
	 * @param designation
	 * @param nouveauPrix
	 * @return
	 */
	int update(String designation, String nouveauPrix);
	
	/**
	 * @param ville
	 * @return
	 */
	boolean delete(Ville ville);
	
	int populationVille(String ville);

}
