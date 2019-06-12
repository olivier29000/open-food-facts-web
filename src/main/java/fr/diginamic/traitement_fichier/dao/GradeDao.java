package fr.diginamic.traitement_fichier.dao;

import java.util.ArrayList;
import java.util.List;

import fr.diginamic.models.Grade;

public class GradeDao {

	public List<Grade> recupererAllGrades() {

		List<Grade> listeDeGrades = new ArrayList<>();

		listeDeGrades.add(new Grade("a"));
		listeDeGrades.add(new Grade("b"));
		listeDeGrades.add(new Grade("c"));
		listeDeGrades.add(new Grade("d"));
		listeDeGrades.add(new Grade("e"));
		listeDeGrades.add(new Grade("f"));
		listeDeGrades.add(0, new Grade("indeterminé"));
		return listeDeGrades;

	}

}
