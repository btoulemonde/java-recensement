package fr.diginamic.recensement.dao;

import java.util.List;

import fr.diginamic.recensement.entites.Departement;
import fr.diginamic.recensement.entites.Ville;

public interface DepartementDao {
	/**Méthode permettant d'extraire une liste des départements
	 * @return retourne une liste des départements
	 */
	List<Departement> extraire();
	
	/**méthode pour insérer toutes les départements vers la base de donnée.
	 * @param List<Ville> : liste des départements
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
	
	/**méthode permettant de retourner la population totale d'un département
	 * @param codeDepartement : code du département 
	 * @return int : population totale du département
	 */
	int populationDep(String codeDepartement);
	
	/**Méthode permettant de créer une liste des villes d'un département trié par ordre décroissant de la population
	 * @param codeDpt : code du département
	 * @return List villes triée
	 */
	public List<Ville> topVille(String codeDpt);

}
