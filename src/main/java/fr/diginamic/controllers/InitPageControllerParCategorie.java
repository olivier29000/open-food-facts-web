package fr.diginamic.controllers;

import java.io.IOException;
import java.util.ArrayList;
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
import fr.diginamic.traitement_fichier.dao.CategorieDao;
import fr.diginamic.traitement_fichier.dao.GradeDao;
import fr.diginamic.traitement_fichier.dao.MarqueDao;

@WebServlet(urlPatterns = "/init2/*")

public class InitPageControllerParCategorie extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// recupere la valeur d'un parametre dont le nom est idCategorie
		String idCategorie = req.getParameter("idCategorie");
		String idMarque = req.getParameter("idMarque");
		String grade = req.getParameter("grade");

		CategorieDao categorieDao = new CategorieDao();
		MarqueDao marqueDao = new MarqueDao();
		GradeDao gradeDao = new GradeDao();

		List<Marque> listeDesMarques = new ArrayList<>();
		List<Categorie> listeDesCategories = new ArrayList<>();
		List<Grade> listeDesGrades = gradeDao.recupererAllGrades();

		if (Integer.parseInt(idCategorie) == -1) {
			listeDesMarques = marqueDao.recupererAllMarques();
		} else {
			listeDesMarques = marqueDao.recupererAllMarques(idCategorie);
		}

		if (Integer.parseInt(idMarque) == -1) {
			listeDesCategories = categorieDao.recupererAllCategories();
		} else {
			listeDesCategories = categorieDao.recupererAllCategories(idMarque);
		}

		req.setAttribute("categories", listeDesCategories);
		req.setAttribute("marques", listeDesMarques);
		req.setAttribute("idCategorie", idCategorie);
		req.setAttribute("idMarque", idMarque);
		req.setAttribute("grade", grade);
		req.setAttribute("grades", listeDesGrades);

		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
		requestDispatcher.forward(req, resp);
	}

}
