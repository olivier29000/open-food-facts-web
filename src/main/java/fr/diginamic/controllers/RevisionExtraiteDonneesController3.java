package fr.diginamic.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/revision3/*")

public class RevisionExtraiteDonneesController3 extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {

		Object utilisateur = req.getAttribute("utilisateur");
		String user = (String) utilisateur;

		rep.getWriter().write("<h1>troisieme servlet</h1>" + "<ul>" + "<li>joueur=" + user + "</li>" + "</ul>");

	}
}
