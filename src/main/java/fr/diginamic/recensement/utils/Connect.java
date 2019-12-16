package fr.diginamic.recensement.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Connect {
	private static ResourceBundle bundle = ResourceBundle.getBundle("database");
	private static String driver = bundle.getString("driver");
	private static String url = bundle.getString("url");
	private static String user = bundle.getString("user");
	private static String password = bundle.getString("password");
	private static Connection connexion;
	
	
	public Connect(){
		connexion = getConnection();
	}
	

	/**Méthode permttant de charger le driver mariadb
	 * @return retourne un boolean true si le driver est chargé
	 */
	public static boolean driver() {

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}

	/**Méthode pour la connexion à la base de donnée dont les paramètres sont saisies dans le fichier database.properties
	 * @return retourne un type Connection
	 */
	public static Connection getConnection() {
		if (driver() != true) {
			driver();
		}
		
		try {
			if (connexion == null){
			connexion = DriverManager.getConnection(url, user, password);
			System.out.println("ouverture connexion");
			}
		} catch (SQLException e) {
			System.out.println("echec de l'ouverture de la base de données");
		}
		return connexion;
	}

	/**Méthode pour créer, mettre à jour ou supprimer des éléments dans la base de donnée
	 * @param sql = commande SQL
	 * @return un attribut de type PreparedStatement
	 */
	public static PreparedStatement cud(String sql) {

//		Connection connexion = null;
		PreparedStatement statement = null;
		try {
//			connexion = getConnection();

			statement = connexion.prepareStatement(sql);
			statement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			try {
				if (connexion != null) {
					connexion.rollback();
				}
			} catch (SQLException e1) {
				System.out.println("echec du rollback");
			}
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				connexion.commit();
				
					
				
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
		return statement;
	}

	/**Méthode pour fermer la connexion à la base de donnée
	 * 
	 */
	public static void connexionClose(){
		try {
			if (connexion != null) {
				connexion.close();
				System.out.println("fermeture connexion");
			}
		} catch (SQLException e) {
			System.out.println("echec de la fermeture de connexion");
		}
	}

	/**Méthode pour selectionner des éléments dans la base de donnée
	 * @param sql = commande SQL
	 * @return resulSet
	 */
	public static ResultSet select(String sql) {
		Connection connexion = null;
		Statement statement = null;
		ResultSet curseur = null;
		try {
			connexion = getConnection();
			statement = connexion.createStatement();
			curseur = statement.executeQuery(sql);

		} catch (SQLException e) {

		} finally {
			try {
				if (statement != null) {
					statement.close();
					
				}
			} catch (SQLException e) {

				System.out.println("echec de la fermeture des ressources");
			}

		}
		return curseur;
	}
}
