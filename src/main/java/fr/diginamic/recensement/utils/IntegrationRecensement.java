package fr.diginamic.recensement.utils;

import java.util.List;

import fr.diginamic.recensement.dao.DepartementDaoJdbc;
import fr.diginamic.recensement.dao.RegionDaoJdbc;
import fr.diginamic.recensement.dao.VilleDaoJdbc;
import fr.diginamic.recensement.entites.Ville;

public class IntegrationRecensement {

	public IntegrationRecensement(){
		Recensement recensement = LectureFichier.lire("C:/work/recensement population 2016.csv");
		List<Ville> villes = recensement.getVilles();
	
		VilleDaoJdbc villeDao = new VilleDaoJdbc();
		DepartementDaoJdbc departementDao = new DepartementDaoJdbc();
		RegionDaoJdbc regionDao = new RegionDaoJdbc();
		
		regionDao.insert(villes);
		
		departementDao.insert(villes);
		
		villeDao.insert(villes);
		
		Connect.connexionClose();

	}

}
