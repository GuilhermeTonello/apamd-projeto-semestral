package gui.projetosemestral.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gui.projetosemestral.database.config.DatabaseConfig;
import gui.projetosemestral.modelos.Filme;

public class FilmeDao implements GenericDao<Filme, Integer> {
	
	@Override
	public Filme procurarPorId(Integer id) throws SQLException {
		String sql = "SELECT * FROM filmes WHERE id = ?";
		
		DatabaseConfig dbConfig = new DatabaseConfig();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Filme filme = mapFromResultSetToObject(rs);
				return filme;
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Filme> procurarTodos() throws SQLException {
		String sql = "SELECT id, titulo, sinopse, genero, onde_assistir, assistido, avaliacao FROM filmes";
		
		DatabaseConfig dbConfig = new DatabaseConfig();
		List<Filme> filmes = new ArrayList<>();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				Filme filme = mapFromResultSetToObject(rs);
				filmes.add(filme);
			}
			return filmes;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void cadastrar(Filme filme) throws SQLException {
		String sql = "INSERT INTO filmes(titulo, sinopse, genero, onde_assistir, assistido, avaliacao, imagem) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		DatabaseConfig dbConfig = new DatabaseConfig();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getSinopse());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getOndeAssistir());
			ps.setBoolean(5, filme.isAssistido());
			ps.setDouble(6, filme.getAvaliacao());
			ps.setString(7, filme.getImagem() == null ? "" : filme.getImagem());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void atualizar(Filme filme) throws SQLException {
		String sql = "UPDATE filmes SET titulo = ?, sinopse = ?, genero = ?, onde_assistir = ?, assistido = ?, avaliacao = ?, imagem = ? WHERE id = ?";
		
		DatabaseConfig dbConfig = new DatabaseConfig();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, filme.getTitulo());
			ps.setString(2, filme.getSinopse());
			ps.setString(3, filme.getGenero());
			ps.setString(4, filme.getOndeAssistir());
			ps.setBoolean(5, filme.isAssistido());
			ps.setDouble(6, filme.getAvaliacao());
			ps.setString(7, filme.getImagem());
			ps.setInt(8, filme.getId());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deletarPorId(Integer id) throws SQLException {
		String sql = "DELETE FROM filmes WHERE id = ?";
		
		DatabaseConfig dbConfig = new DatabaseConfig();
		try (Connection con = dbConfig.getConexao();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Filme mapFromResultSetToObject(ResultSet rs) throws SQLException {
		Filme filme = new Filme();
		filme.setId(rs.getInt("id"));
		filme.setAssistido(rs.getBoolean("assistido"));
		filme.setGenero(rs.getString("genero"));
		filme.setOndeAssistir(rs.getString("onde_assistir"));
		filme.setSinopse(rs.getString("sinopse"));
		filme.setTitulo(rs.getString("titulo"));
		filme.setAvaliacao(rs.getDouble("avaliacao"));
		return filme;
	}
	
}
