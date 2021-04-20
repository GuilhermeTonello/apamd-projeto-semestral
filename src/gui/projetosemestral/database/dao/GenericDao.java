package gui.projetosemestral.database.dao;

import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T, I> {
	
	T procurarPorId(I id) throws SQLException;
	
	List<T> procurarTodos() throws SQLException;
	
	void cadastrar(T o) throws SQLException;
	
	void atualizar(T o) throws SQLException;
	
	void deletarPorId(I id) throws SQLException;
	
}
