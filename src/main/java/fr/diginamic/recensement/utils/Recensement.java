package fr.diginamic.recensement.utils;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.recensement.entites.Ville;

public class Recensement {

	private List<Ville> villes = new ArrayList<>();

	public List<Ville> getVilles() {
		return villes;
	}

	public void setVilles(List<Ville> villes) {
		this.villes = villes;
	}

}
