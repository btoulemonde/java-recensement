package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import fr.diginamic.recensement.difficile.utils.Connect;
import fr.diginamic.recensement.facile.Ville;

public class VilleDaoJdbc implements VilleDao {
	PreparedStatement insert;
	
	private static Connection connexion;
	
			
	@Override
	public List<Ville> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Ville ville) {
		connexion = Connect.getConnection();
		try {
			insert = connexion.prepareStatement("INSERT INTO VILLE(NOM_VILLE, CODE_REGION, CODE_DEPARTEMENT, POPULATION) VALUES(?,?,?,?)");
			insert.setString(1, ville.getNomCommune());
			insert.setInt(2, Integer.parseInt(ville.getCodeRegion()));
			insert.setString(3, ville.getCodeDepartement());
			insert.setInt(4, ville.getPopulation());
			
			insert.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		

	}

	@Override
	public int update(String designation, String nouveauPrix) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Ville ville) {
		// TODO Auto-generated method stub
		return false;
	}

}
