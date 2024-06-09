package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexioManager {
	
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.56.101/user", "mdian", "passer");
			return connection;
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de chargement du Driver");
			return null;
		} 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost/gestionuser", "root", "");
			System.out.println("connexion reussie");
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.err.println("Erreur de chargement du Driver");
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Erreur d'Execution de la requête");
		}
		

	}

}
