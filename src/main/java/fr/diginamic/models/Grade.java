package fr.diginamic.models;

public class Grade {
	private String gradeNutritionnel;

	/**
	 * Constructeur
	 * 
	 * @param gradeNutritionnel
	 */
	public Grade(String gradeNutritionnel) {
		super();
		this.gradeNutritionnel = gradeNutritionnel;
	}

	/**
	 * @return the gradeNutritionnel
	 */
	public String getGradeNutritionnel() {
		return gradeNutritionnel;
	}

	/**
	 * Setter
	 * 
	 * @param gradeNutritionnel
	 *            the gradeNutritionnel to set
	 */
	public void setGradeNutritionnel(String gradeNutritionnel) {
		this.gradeNutritionnel = gradeNutritionnel;
	}

}
