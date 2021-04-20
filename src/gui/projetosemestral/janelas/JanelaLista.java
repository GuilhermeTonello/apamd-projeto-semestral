package gui.projetosemestral.janelas;

import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.projetosemestral.database.dao.FilmeDao;
import gui.projetosemestral.modelos.Filme;

public class JanelaLista extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private FilmeDao filmeDao = new FilmeDao();
	
	public JanelaLista() {
		init();
	}
	
	private void init() {
		setLayout(new GridLayout());
        try {
			List<Filme> filmes = filmeDao.procurarTodos();
			
			@SuppressWarnings("serial")
			DefaultTableModel modelo = new DefaultTableModel() {
				public boolean isCellEditable(int row, int col) {
					return false;
				}
			};
			JTable tabela = new JTable(modelo);
			
			configureTableModel(modelo);
			configureTable(tabela);
			
			filmes.forEach(filme -> {
				modelo.addRow(new Object[] {
					filme.getTitulo(),
					filme.getSinopse(),
					filme.getGenero(),
					filme.getOndeAssistir(),
					filme.isAssistido() ? "SIM" : "NÃO",
					filme.getAvaliacao(),
				});
			});
			
			JScrollPane scroll = new JScrollPane(tabela);
			add(scroll);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void configureTableModel(DefaultTableModel modelo) {
		modelo.addColumn("TÍTULO");
		modelo.addColumn("SINOPSE");
		modelo.addColumn("GÊNERO");
		modelo.addColumn("ONDE ASSISTIR");
		modelo.addColumn("ASSISTIDO");
		modelo.addColumn("AVALIAÇÃO");
	}
	
	private void configureTable(JTable tabela) {
		tabela.setFont(new Font(null, Font.PLAIN, 16));
	}

}
