package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Dao.UtilisateurDao;
import beans.Utilisateur;

/**
 * Servlet implementation class UpdateUser
 */
public class UpdateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_UTILISATEUR = "/WEB-INF/update.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		Utilisateur utilisateur = UtilisateurDao.getById(Integer.parseInt(id));
		if(utilisateur == null) {
			response.getWriter().println("utilisateur non trouvé !!!");
		}
		else {
			request.setAttribute("user", utilisateur);
			this.getServletContext().getRequestDispatcher(VUE_UTILISATEUR).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = new Utilisateur(
				Integer.parseInt(request.getParameter("id")),
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("login"),
				request.getParameter("password")
		);
		
		UtilisateurDao.update(utilisateur);
		
		response.sendRedirect("list");
		
	}

}
