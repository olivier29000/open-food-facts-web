package fr.diginamic.models;

public class Produit {

	private int id;
	private String energie;
	private String fibres;
	private String grade;
	private String graisse;
	private String nom;
	private String pays;
	private String paysManufact;
	private String proteine;
	private String sel;
	private String sucre;
	private String id_marque;
	private int id_categorie;

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param energie
	 * @param fibres
	 * @param grade
	 * @param graisse
	 * @param nom
	 * @param pays
	 * @param paysManufact
	 * @param proteine
	 * @param sel
	 * @param sucre
	 * @param id_marque
	 * @param id_categorie
	 */
	public Produit(int id, String energie, String fibres, String grade, String graisse, String nom, String pays,
			String paysManufact, String proteine, String sel, String sucre, String id_marque, int id_categorie) {
		super();
		this.id = id;
		this.energie = energie;
		this.fibres = fibres;
		this.grade = grade;
		this.graisse = graisse;
		this.nom = nom;
		this.pays = pays;
		this.paysManufact = paysManufact;
		this.proteine = proteine;
		this.sel = sel;
		this.sucre = sucre;
		this.id_marque = id_marque;
		this.id_categorie = id_categorie;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 * @param nom
	 * @param marque
	 * @param categorie
	 * @param grade
	 */
	public Produit(String nom, String marque, int categorie, String grade) {
		super();

		this.nom = nom;
		this.id_marque = marque;
		this.id_categorie = categorie;
		this.grade = grade;
	}

	public Produit(Integer id, String nom, String marque, int categorie, String grade) {
		super();

		this.nom = nom;
		this.id_marque = marque;
		this.id_categorie = categorie;
		this.grade = grade;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return id_marque;
	}

	/**
	 * Setter
	 * 
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.id_marque = marque;
	}

	/**
	 * @return the categorie
	 */
	public int getCategorie() {
		return id_categorie;
	}

	/**
	 * Setter
	 * 
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(int categorie) {
		this.id_categorie = categorie;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * Setter
	 * 
	 * @param grade
	 *            the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
