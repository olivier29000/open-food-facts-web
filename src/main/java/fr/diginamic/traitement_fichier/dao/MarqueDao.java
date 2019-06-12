package fr.diginamic.traitement_fichier.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.models.Marque;
import fr.diginamic.traitement_fichier.Exceptions.TechnicalException;
import fr.diginamic.utils.ConnectionUtils;

public class MarqueDao {

	public List<Marque> recupererAllMarques(String idCategorie) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Marque> listeDeMarques = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement(
					"select distinct(mrq.id), mrq.nom from produits prd, marques mrq where id_mrq=mrq.id and id_cat="
							+ idCategorie);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("mrq.id");
				String nom = resultSet.getString("mrq.nom");
				listeDeMarques.add(new Marque(id, nom));
			}
			listeDeMarques.add(0, new Marque(-1, "indeterminé"));
			return listeDeMarques;
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

	public List<Marque> recupererAllMarques() {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Marque> listeDeMarques = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance().prepareStatement("select * from marques");
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("ID");
				String nom = resultSet.getString("NOM");
				listeDeMarques.add(new Marque(id, nom));
			}
			listeDeMarques.add(0, new Marque(-1, "indeterminé"));
			return listeDeMarques;
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
