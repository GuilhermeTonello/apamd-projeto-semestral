package gui.projetosemestral.servicos;

import java.util.List;

import gui.projetosemestral.dao.GenericDao;
import gui.projetosemestral.modelos.Filme;

public class FilmeService {
	
	private GenericDao<Filme> dao = new GenericDao<Filme>(Filme.class, "projeto-semestral");
	
	public void cadastrar(Filme filme) {
		dao.cadastrar(filme);
	}

	public List<Filme> procurarTodos() {
		return dao.procurarTodos();
	}
	
}
