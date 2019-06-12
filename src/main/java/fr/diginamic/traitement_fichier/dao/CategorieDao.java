package fr.diginamic.traitement_fichier.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.models.Categorie;
import fr.diginamic.traitement_fichier.Exceptions.TechnicalException;
import fr.diginamic.utils.ConnectionUtils;

public class CategorieDao {

	public List<Categorie> recupererAllCategories(String idMarque) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Categorie> listeDeCategories = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select distinct(cat.id), cat.nom from produits prd, categories cat where id_cat=cat.id and id_mrq="
							+ idMarque);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("id");
				String nom = resultSet.getString("nom");
				listeDeCategories.add(new Categorie(id, nom));
			}
			listeDeCategories.add(0, new Categorie(-1, "indeterminé"));
			return listeDeCategories;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

	public List<Categorie> recupererAllCategories() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Categorie> listeDeCategories = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from categories");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("ID");
				String nom = resultSet.getString("NOM");
				listeDeCategories.add(new Categorie(id, nom));
			}
			listeDeCategories.add(0, new Categorie(-1, "indeterminé"));
			return listeDeCategories;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de selection en base", e);
			throw new TechnicalException("probleme de selection en base", e);

		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le resultSet",
					// e);
					throw new TechnicalException("impossible de fermer le resultSet", e);
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// SERVICE_LOG.error("impossible de fermer le statement",
					// e);
					throw new TechnicalException("impossible de fermer le statement", e);
				}
			}
			ConnectionUtils.doClose();
		}
	}

}
