package eu.ensup.gestionetablissement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connect.
 */
public class Connect
{
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://mysql-gestionetablissement.alwaysdata.net:3306/gestionetablissement_ensup?serverTimezone=UTC";
	private static final String USERNAME = "225269";
	private static final String PASSWORD = "GestionEtablissement";

	/**
	 * Open an connention with the information in the class
	 *
	 * @return an connection open
	 */
	public static Connection openConnection() throws ExceptionDao
	{
		Connection cn = null;
		try
		{
			//Chargement du Driver
			Class.forName(DRIVER);
			//?useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC
			
			//Récuperation de la connection
			if( URL != null && USERNAME != null && PASSWORD != null )
				cn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			if( cn == null && URL != null )
				cn = DriverManager.getConnection(URL);

			// TODO:  Add logger failed and successfull
		}
		catch (ClassNotFoundException | SQLException e){
			// TODO:  Add logger failed and successfull
			throw new ExceptionDao("Nous ne parvenons pas à joindre le serveur distant. Veuillez réessayer ultérieurement");
		}
		
		return cn;
	}
}
