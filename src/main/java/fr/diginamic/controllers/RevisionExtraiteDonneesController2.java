package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/revision2/*")

public class RevisionExtraiteDonneesController2 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

		// Récupérer la session existante ou création d'une session
		HttpSession session = req.getSession(false);

		// Récupérer une valeur stockée Object utilisateur =

		Object utilisateur1 = session.getAttribute("joueur1");
		Object utilisateur2 = session.getAttribute("joueur2");
		Object utilisateur3 = session.getAttribute("joueur3");

		String user1 = (String) utilisateur1;
		String user2 = (String) utilisateur2;
		String user3 = (String) utilisateur3;

		rep.getWriter().write("<h1>deuxième servlet</h1>" + "<ul>" + "<li>identifiant=" + user1 + "</li>"
				+ "<li>identifiant=" + user2 + "</li>" + "<li>identifiant=" + user3 + "</li>" + "</ul>");

	}
}
