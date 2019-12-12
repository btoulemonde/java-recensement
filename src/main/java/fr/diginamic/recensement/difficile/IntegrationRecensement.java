package fr.diginamic.recensement.difficile;

import java.util.List;
import fr.diginamic.recensement.dao.VilleDaoJdbc;
import fr.diginamic.recensement.difficile.utils.Connect;
import fr.diginamic.recensement.facile.Ville;

public class IntegrationRecensement {

	public static void main(String[] args) {
		Recensement recensement = LectureFichier.lire("C:/work/recensement population 2016.csv");
		List<Ville> villes = recensement.getVilles();
		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		
		for(Ville ville : villes){
			
			villeDao.insert(ville);
			
		}
		
		

	}

}
