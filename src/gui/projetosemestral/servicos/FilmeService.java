package gui.projetosemestral.servicos;

import java.util.List;

import gui.projetosemestral.dao.GenericDao;
import gui.projetosemestral.modelos.Filme;

public class FilmeService {
	
	private GenericDao<Filme, Integer> dao = new GenericDao<>(Filme.class, "projeto-semestral");
	
	public void cadastrar(Filme filme) {
		dao.cadastrar(filme);
	}

	public List<Filme> procurarTodos() {
		return dao.procurarTodos();
	}
	
	public void deletarPorId(Integer id) {
		dao.deletarPorId(id);
	}
	
	public void atualizar(Filme filme) {
		dao.atualizar(filme);
	}
	
	public Filme findById(Integer id) {
		return dao.findById(id);
	}
	
}
