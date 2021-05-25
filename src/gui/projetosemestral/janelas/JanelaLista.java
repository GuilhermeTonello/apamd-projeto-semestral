package gui.projetosemestral.janelas;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import gui.projetosemestral.componentes.BarraDeNavegacao;
import gui.projetosemestral.componentes.CampoImagem;
import gui.projetosemestral.componentes.CamposCadastro;
import gui.projetosemestral.componentes.CamposExtras;
import gui.projetosemestral.modelos.Filme;
import gui.projetosemestral.servicos.FilmeService;

public class JanelaLista extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private FilmeService filmeService = new FilmeService();
	
	public JanelaLista() {
		init();
	}
	
	private void init() {
		setLayout(new GridLayout(2, 1));
		List<Filme> filmes = filmeService.procurarTodos();
		
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
				filme.getId(),
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
		
		JPanel botoes = new JPanel();
		
		JButton deletar = new JButton("Deletar");
		deletar.addActionListener(acao -> {
			int linha = tabela.getSelectedRow();
			if (linha >= 0) {
				Integer id = Integer.valueOf(tabela.getValueAt(linha, 0).toString());
				String nome = tabela.getValueAt(linha, 1).toString();
				int confirma = JOptionPane.showConfirmDialog(null, String.format("Tem certeza que desejar deletar o filme %s?", nome), "Deletar", JOptionPane.YES_NO_OPTION);
				switch(confirma) {
					case JOptionPane.YES_OPTION:
						System.out.println("Deletando...");
						//filmeService.deletarPorId(id);
					break;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha antes", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JButton editar = new JButton("Editar");
		editar.addActionListener(acao -> {
			int linha = tabela.getSelectedRow();
			if (linha >= 0) {
				Integer id = Integer.valueOf(tabela.getValueAt(linha, 0).toString());
				String titulo = tabela.getValueAt(linha, 1).toString();
				String sinopse = tabela.getValueAt(linha, 2).toString();
				String genero = tabela.getValueAt(linha, 3).toString();
				
				String ondeAssistir = tabela.getValueAt(linha, 4).toString();
				
				Boolean assistido = tabela.getValueAt(linha, 5).toString().equalsIgnoreCase("SIM")
						? true
						: false;
				String avaliacao = tabela.getValueAt(linha, 6).toString();
				
				BarraDeNavegacao nav = JanelaPrincipal.nav;
				nav.setSelectedIndex(0);
				JanelaCadastro janelaCadastro = (JanelaCadastro) nav.getComponent(0);
				
				CamposCadastro camposCadastro = janelaCadastro.getCamposCadastro();
				CamposExtras camposExtras = janelaCadastro.getCamposExtras();
				
				camposCadastro.getCampoId().setText(String.valueOf(id));
				camposCadastro.getTituloCampo().setText(titulo);
				camposCadastro.getSinopseCampo().setText(sinopse);
				camposCadastro.getGeneroCampo().setSelectedItem(genero);
				
				camposExtras.getOndeAssistirGrupo().getElements().asIterator()
					.forEachRemaining(botao -> {
						if (botao.getActionCommand().equalsIgnoreCase(ondeAssistir)) {
							botao.setSelected(true);
						}
					});
				
				System.out.println();
				camposExtras.getAssistido().setSelected(assistido);
				camposExtras.getStarRater().setRating(Float.valueOf(avaliacao));
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha antes", "Erro", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		botoes.add(deletar);
		botoes.add(editar);
		add(botoes);
	}
	
	private void configureTableModel(DefaultTableModel modelo) {
		modelo.addColumn("ID");
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
