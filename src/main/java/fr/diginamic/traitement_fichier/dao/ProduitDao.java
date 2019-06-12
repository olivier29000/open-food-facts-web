package fr.diginamic.traitement_fichier.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.models.Produit;
import fr.diginamic.traitement_fichier.Exceptions.TechnicalException;
import fr.diginamic.utils.ConnectionUtils;

public class ProduitDao {

	public List<Produit> recupererAllProduits(String idCategorie) {

		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Produit> listeDeProduits = new ArrayList<>();

		try {
			preparedStatement = ConnectionUtils.getInstance()
					.prepareStatement("select * from produits where id_cat=" + idCategorie);
			resultSet = preparedStatement.executeQuery();
			ConnectionUtils.doCommit();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("ID");
				String energie = resultSet.getString("NOM");
				String fibres = resultSet.getString("NOM");
				String grade = resultSet.getString("NOM");
				String graisse = resultSet.getString("NOM");
				String nom = resultSet.getString("NOM");
				String pays = resultSet.getString("NOM");
				String paysManufact = resultSet.getString("NOM");
				String proteine = resultSet.getString("NOM");
				String sel = resultSet.getString("NOM");
				String sucre = resultSet.getString("NOM");
				String id_marque = resultSet.getString("id_mrq");
				int id_categorie = resultSet.getInt("id_cat");

				listeDeProduits.add(new Produit(nom, id_marque, id_categorie, grade));
			}
			return listeDeProduits;
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
