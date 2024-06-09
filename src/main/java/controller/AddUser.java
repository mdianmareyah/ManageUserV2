package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.UtilisateurDao;
import beans.Utilisateur;
import forms.AddUserForm;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_UTILISATEUR = "/WEB-INF/add.jsp";
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		AddUserForm addForm = new AddUserForm(request);
		
		if( addForm.Ajouter()) {
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("status", addForm.isStatus());
			request.setAttribute("statusMessage", addForm.getStatusMessage());
			request.setAttribute("erreurs", addForm.getErreurs());
			request.setAttribute("utilisateur", addForm.getUtilisateur());
			
			this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR).forward(request, response);
		}
	}

}
