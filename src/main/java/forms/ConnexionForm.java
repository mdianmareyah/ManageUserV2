package forms;

import java.util.HashMap;
import java.util.Map;

import Dao.UtilisateurDao;
import beans.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ConnexionForm {
	
	
	private static final String CHAMP_LOGIN = "login";
	private static final String CHAMP_PASSWORD = "password";
	
	
	private String statusMessage;
	private boolean status;
	private HttpServletRequest request;
	private Map<String, String> erreurs ;
	
	private Utilisateur utilisateur;
	
	private String login;
	
	public ConnexionForm(HttpServletRequest request) {
		this.request = request;
		this.status = false;
		this.statusMessage = "Echec de la connexion : login et/ou Mot de passe incorrect";
		
		this.erreurs = new HashMap<String, String>();
	}

	public boolean Login() {
		
		this.login = this.getParameter(CHAMP_LOGIN);
		String password = this.getParameter(CHAMP_PASSWORD);
		
		Utilisateur loggedUser = UtilisateurDao.login(login, password);
		
		if(loggedUser != null && password.equals(loggedUser.getPassword())) {
			HttpSession session = request.getSession();
			session.setAttribute("loggedUser", loggedUser);
			return true;
		}
		
		return false;
	}
	
	public void logOut() {
		request.getSession().invalidate();
	}
	private String getParameter(String parameter) {
		
		String valeur = this.request.getParameter(parameter);
		if(valeur == null || valeur.isBlank()) {
			return null;
		}
		
		return valeur.trim();
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}
