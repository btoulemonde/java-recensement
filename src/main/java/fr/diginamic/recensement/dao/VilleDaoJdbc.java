package fr.diginamic.recensement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fr.diginamic.recensement.difficile.utils.Connect;
import fr.diginamic.recensement.facile.Ville;

public class VilleDaoJdbc implements VilleDao {
	PreparedStatement statement;

	private static Connection connexion;

	public VilleDaoJdbc() {
		connexion = Connect.getConnection();
	}

	@Override
	public List<Ville> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.diginamic.recensement.dao.VilleDao#insert(java.util.List)
	 */
	@Override
	public void insert(List<Ville> villes) {
		// connexion = Connect.getConnection();
		try {

			for (Ville ville : villes) {
				statement = connexion.prepareStatement(
						"INSERT INTO VILLE(NOM_VILLE, CODE_REGION, CODE_DEPARTEMENT, POPULATION) VALUES(?,?,?,?)");
				statement.setString(1, ville.getNomCommune());
				statement.setInt(2, Integer.parseInt(ville.getCodeRegion()));
				statement.setString(3, ville.getCodeDepartement());
				statement.setInt(4, ville.getPopulation());

				statement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("echec de l'ajout");
			;
		}
	}

	public int update(String designation, String nouveauPrix) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Ville ville) {
		try {
			statement = connexion.prepareStatement("DELETE FROM VILLE WHERE NOM_VILLE =?");
			statement.setString(1, ville.getNomCommune());
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("echec de la suppression");
		}
		return false;
	}

}
