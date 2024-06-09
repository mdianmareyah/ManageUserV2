package forms;

import java.util.HashMap;
import java.util.Map;

import Dao.UtilisateurDao;
import beans.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;

public class AddUserForm {
	
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	private static final String CHAMP_PASSWORD_BIS = "passwordBis";
	
	
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private Map<String, String> erreurs ;
	
	private Utilisateur utilisateur;
	
	
	public AddUserForm(HttpServletRequest request) {
		this.request = request;
		this.erreurs = new HashMap<String, String>();
	}

	public boolean Ajouter() {
		
		String nom = this.getParameter(CHAMP_NOM);
		String prenom = this.getParameter(CHAMP_PRENOM);
		String login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.getParameter(CHAMP_PASSWORD_BIS);
		
		
		this.utilisateur = new Utilisateur(nom, prenom, login, password);
		this.statusMessage = "Echec de l'ajout !";
		this.status = false;
		
		this.validerChamps(CHAMP_NOM,CHAMP_PRENOM,CHAMP_LOGIN,CHAMP_PASSWORD,CHAMP_PASSWORD_BIS);
		this.validerPasswords();
		
		
		if(this.erreurs.isEmpty()) {
			
			UtilisateurDao.ajouter(utilisateur);
			this.statusMessage = "Ajouter avec Succès !";
			this.status = true;
			return true;
		}
		
		return false;
	}
	
	private String getParameter(String parameter) {
		
		String valeur = this.request.getParameter(parameter);
		if(valeur == null || valeur.isEmpty()) {
			return null;
		}
		
		return valeur.trim();
	}
	
	private void validerChamps(String ...champs) {
		
		for( String champ: champs) {
			
			if( this.getParameter(champ) == null ) {
				this.erreurs.put(champ, "Vous devez renseigner ce champ !");
			}
		}
	}
	
	private void validerPasswords() {
		
		String password = this.request.getParameter(CHAMP_PASSWORD);
		String passwordBis = this.request.getParameter(CHAMP_PASSWORD_BIS);
		
		if( password != null && !password.equals(passwordBis)) {
			this.erreurs.put(CHAMP_PASSWORD, "les mots de passes ne sont pas conformes");
		}
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Map<String, String> erreurs) {
		this.erreurs = erreurs;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
}
