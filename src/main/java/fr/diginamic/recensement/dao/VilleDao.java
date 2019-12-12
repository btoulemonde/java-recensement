package fr.diginamic.recensement.dao;

import java.util.List;

import fr.diginamic.recensement.facile.Ville;

public interface VilleDao {
	
	/**
	 * @return
	 */
	List<Ville> extraire();
	
	/**
	 * @param ville
	 */
	void insert(Ville ville);
	
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

}
