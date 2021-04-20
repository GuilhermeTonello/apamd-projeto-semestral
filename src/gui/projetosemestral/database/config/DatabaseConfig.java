package gui.projetosemestral.database.config;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
	
	File dir = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParentFile();
	private final String url = "jdbc:sqlite:" + dir.toString().split(";")[0] + File.separator + "filme.db";
	
	private Connection conexao = null;
	
	public Connection getConexao() {
		if (conexao == null) {
			try {
				conexao = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conexao;
	}
	
}
