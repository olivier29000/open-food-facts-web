package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/revision/*")

public class RevisionExtraiteDonneesController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est idCategorie
		String idCategorie = req.getParameter("idCategorie");
		// code HTML ecrit dans le corps de la reponse
		resp.getWriter()
				.write("<h1>Revision à extraire</h1>" + "<ul>" + "<li>personne n°=" + idCategorie + "</li>" + "</ul>");

		// Récupérer la session existante ou création d'une session
		HttpSession session = req.getSession(true);
		// Stocker un utilisateur
		session.setAttribute("joueur1", "yonel");
		session.setAttribute("joueur2", "kevin");
		session.setAttribute("joueur3", "JB");

		/////////// Il est préférable d’utiliser un objet éphémère comme la
		/////////// request pour réaliser ce genre d’opération.
		req.setAttribute("utilisateur", "Cécile");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/revision3");
		dispatcher.forward(req, resp);
	}
}
