package fr.diginamic.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.diginamic.models.Categorie;
import fr.diginamic.models.Grade;
import fr.diginamic.models.Marque;
import fr.diginamic.models.Produit;
import fr.diginamic.traitement_fichier.dao.CategorieDao;
import fr.diginamic.traitement_fichier.dao.GradeDao;
import fr.diginamic.traitement_fichier.dao.MarqueDao;
import fr.diginamic.traitement_fichier.dao.ProduitDao;

@WebServlet(urlPatterns = "/init/*")

public class InitPageController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategorieDao categorieDao = new CategorieDao();
		MarqueDao marqueDao = new MarqueDao();
		GradeDao gradeDao = new GradeDao();
		String idCategorie = "-1";
		String idMarque = "-1";
		String grade = "-1";

		List<Categorie> listeDesCategories = categorieDao.recupererAllCategories();
		List<Marque> listeDesMarques = marqueDao.recupererAllMarques();
		List<Grade> listeDesGrades = gradeDao.recupererAllGrades();

		req.setAttribute("categories", listeDesCategories);
		req.setAttribute("marques", listeDesMarques);
		req.setAttribute("grades", listeDesGrades);
		req.setAttribute("idCategorie", idCategorie);
		req.setAttribute("idMarque", idMarque);
		req.setAttribute("grade", grade);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		String selectedCateg = req.getParameter("selectedCateg");
		ProduitDao produitDao = new ProduitDao();
		List<Produit> listeDeProduits = produitDao.recupererAllProduits(selectedCateg);

		req.setAttribute("produits", listeDeProduits);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/resultatRecherche.jsp");
		dispatcher.forward(req, resp);
	}
}
