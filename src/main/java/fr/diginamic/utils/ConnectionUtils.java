package fr.diginamic.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import fr.diginamic.traitement_fichier.Exceptions.TechnicalException;

public class ConnectionUtils {

	/** SERVICE_LOG : Logger */
	// private static final Logger SERVICE_LOG =
	// LoggerFactory.getLogger(ConnectionUtils.class);

	/** conn : Connection */
	private static Connection conn = null;
	/** bddConf : ResourceBundle */
	private static ResourceBundle bddConf = ResourceBundle.getBundle("database");

	/**
	 * Constructeur
	 * 
	 */
	private ConnectionUtils() {
	}

	/**
	 * Créer une Connection si elle n'éxiste pas, puis la retourne
	 * 
	 * @return Connection
	 */
	public static Connection getInstance() {

		try {
			if (conn == null || conn.isClosed()) {

				try {
					String driverName = ConnectionUtils.getDriverName();
					Class.forName(driverName);
				} catch (ClassNotFoundException e1) {
					// SERVICE_LOG.error("impossible de charger le driver", e1);
					throw new TechnicalException("impossible de charger le driver", e1);
				}

				String bddUrl = bddConf.getString("database.url");
				String bddUser = bddConf.getString("database.user");
				String bddPassword = bddConf.getString("database.password");

				conn = DriverManager.getConnection(bddUrl, bddUser, bddPassword);
				conn.setAutoCommit(false);
			}
			return conn;
		} catch (SQLException e) {
			// SERVICE_LOG.error("probleme de récupération de connexion", e);
			throw new TechnicalException("probleme de récupération de connexion", e);
		}

	}

	/**
	 * @return le nom du driver de la base de données
	 */
	public static String getDriverName() {
		return bddConf.getString("database.driver");
	}

	public static void doCommit() {

		try {
			if (conn != null || conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// SERVICE_LOG.error("impossible de commit", e);
			throw new TechnicalException("impossible de commit", e);
		}

	}

	public static void doRollback() {
		try {
			if (conn != null || conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// SERVICE_LOG.error("impossible de rollback", e);
			throw new TechnicalException("impossible de rollback", e);
		}

	}

	public static void doClose() {
		try {
			if (conn != null || conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// SERVICE_LOG.error("impossible de rollback", e);
			throw new TechnicalException("impossible de rollback", e);
		}

	}

}
