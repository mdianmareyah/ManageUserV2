package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Utilisateur;

public class UtilisateurDao {
	
	private final static ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	
	private static int id = 1;
	
	public static ArrayList<Utilisateur> lister() {
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		
		try {
			Connection connection = ConnexioManager.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from utilisateur");
			
			while (resultSet.next()) {
				utilisateurs.add(new Utilisateur(resultSet.getInt("id"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("login"),resultSet.getString("password")));
			}
			
			resultSet.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de recupération " + e.getMessage());
		}
		
		return utilisateurs;
	}
	
	public static boolean ajouter(Utilisateur utilisateur) {
		
		try {
			Connection connection = ConnexioManager.getConnection();
			
			String requete = "insert into utilisateur (nom, prenom, login, password) values (?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			
			int insert = preparedStatement.executeUpdate();
			
			if( insert == 1) {
				return true;
			}
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur d'insertion " + e.getMessage());
		}
		return false;
	}
	
	public static Utilisateur login(String login, String password) {
		
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			Connection connection = ConnexioManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from utilisateur where login = ? and password = ?");
			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utilisateur.setId(resultSet.getInt("id"));
				utilisateur.setNom(resultSet.getString("nom"));
				utilisateur.setPrenom(resultSet.getString("prenom"));
				utilisateur.setLogin(resultSet.getString("login"));
				utilisateur.setPassword(resultSet.getString("password"));
			}
			
			resultSet.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de recupération " + e.getMessage());
		}
		
		return utilisateur;
	}
	
	public static Utilisateur getById(int id) {
		
		Utilisateur utilisateur = new Utilisateur();
		
		try {
			Connection connection = ConnexioManager.getConnection();
			PreparedStatement statement = connection.prepareStatement("select * from utilisateur where id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				utilisateur.setId(resultSet.getInt("id"));
				utilisateur.setNom(resultSet.getString("nom"));
				utilisateur.setPrenom(resultSet.getString("prenom"));
				utilisateur.setLogin(resultSet.getString("login"));
				utilisateur.setPassword(resultSet.getString("password"));
			}
			
			resultSet.close();
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de recupération " + e.getMessage());
		}
		
		return utilisateur;
	}
	
	public static boolean update(Utilisateur utilisateur) {
		
		try {
			Connection connection = ConnexioManager.getConnection();
			
			String requete = "update utilisateur set nom = ?, prenom = ?, login= ?, password = ? where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			
			preparedStatement.setString(1, utilisateur.getNom());
			preparedStatement.setString(2, utilisateur.getPrenom());
			preparedStatement.setString(3, utilisateur.getLogin());
			preparedStatement.setString(4, utilisateur.getPassword());
			preparedStatement.setInt(5, utilisateur.getId());
			
			int insert = preparedStatement.executeUpdate();
			
			if( insert == 1) {
				return true;
			}
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de Modification " + e.getMessage());
		}
		return false;
	}
	
	public static boolean supprimer(int id) { 
		
		try {
			Connection connection = ConnexioManager.getConnection();
			
			String requete = "delete from utilisateur where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			
			preparedStatement.setInt(1, id);
			
			int insert = preparedStatement.executeUpdate();
			
			if( insert == 1) {
				return true;
			}
			connection.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Erreur de Modification " + e.getMessage());
		}
		return false;
	}
}
