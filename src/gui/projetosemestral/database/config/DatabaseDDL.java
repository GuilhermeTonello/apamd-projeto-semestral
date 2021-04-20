package gui.projetosemestral.database.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseDDL {
	
	public static void createTable() {
		String sql = " CREATE TABLE IF NOT EXISTS filmes ";
		sql = sql.concat(" (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, ");
		sql = sql.concat(" titulo VARCHAR(255), ");
		sql = sql.concat(" sinopse VARCHAR(255), ");
		sql = sql.concat(" genero VARCHAR(255), ");
		sql = sql.concat(" onde_assistir VARCHAR(255), ");
		sql = sql.concat(" assistido BOOLEAN, ");
		sql = sql.concat(" avaliacao DOUBLE, ");
		sql = sql.concat(" imagem text); ");

		DatabaseConfig dbConfig = new DatabaseConfig();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
