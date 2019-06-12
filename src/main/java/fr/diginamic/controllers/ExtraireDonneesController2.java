package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/extraire2/*")

public class ExtraireDonneesController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(
				"<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\"><title>Document</title></head><body>Hello 2eme ExtraireDonneesController");

		// recupere la valeur d'un parametre dont le nom est idCategorie
		String idCategorie = req.getParameter("idCategorie");
		String idMarque = req.getParameter("idMarque");
		// code HTML ecrit dans le corps de la reponse
		resp.getWriter().write("<h1>Categorie à extraire</h1>" + "<ul>" + "<li>identifiant=" + idMarque + "</li>"
				+ "</ul></body></html>");
		// code HTML ecrit dans le corps de la reponse
		resp.getWriter().write("<h1>Categorie à extraire</h1>" + "<ul>" + "<li>identifiant=" + idCategorie + "</li>"
				+ "</ul></body></html>");
		/**
		 * // Récupérer la session existante ou création d'une session
		 * HttpSession session = req.getSession(true);
		 * 
		 * // Récupérer une valeur stockée Object utilisateur =
		 * session.getAttribute("utilisateur");
		 * 
		 * String user = (String) utilisateur;
		 * 
		 */
		// Stocker un utilisateur
		// Récupérer une valeur stockée
		Object utilisateur = req.getAttribute("utilisateur");
		String user = (String) utilisateur;
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().write("<h1>deuxième servlet</h1>" + "<ul>" + "<li>identifiant=" + user + "</li>" + "</ul>");

	}
}
