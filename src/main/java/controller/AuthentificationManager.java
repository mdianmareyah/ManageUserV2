package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import forms.ConnexionForm;

/**
 * Servlet implementation class AuthentificationManager
 */
@WebServlet("/logout")
public class AuthentificationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String VUE_LOGIN = "/WEB-INF/login.jsp";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		switch (request.getServletPath()) {
		case "/login":
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			break;
		case "/":
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
			break;
		default:
			ConnexionForm connexionForm = new ConnexionForm(request);
			connexionForm.logOut();
			response.sendRedirect("login");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ConnexionForm connexionForm = new ConnexionForm(request);
		
		if(connexionForm.Login()) {
			response.sendRedirect("list");
		}
		else {
			request.setAttribute("login", connexionForm.getLogin());
			request.setAttribute("status", connexionForm.isStatus());
			request.setAttribute("statusMessage", connexionForm.getStatusMessage());
			this.getServletContext().getRequestDispatcher(VUE_LOGIN).forward(request, response);
		}
	}

}
