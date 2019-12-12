package fr.diginamic.recensement.difficile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class LectureFichier {

	public static Recensement lire(String cheminFichier) {
		Recensement recensement = new Recensement();
		
		List<String> lignes = new ArrayList<String>();
		try{
		File file = new File(cheminFichier);
		lignes = FileUtils.readLines(file, "UTF-8");
		
		lignes.remove(0);
		
		for (String ligne:lignes){
			ParseurVille.ajoutLigne(recensement, ligne);
		}
		return recensement;
		
		}catch (IOException e){
			System.out.println(e.getMessage());
			return null;
		}
		
	}

}
