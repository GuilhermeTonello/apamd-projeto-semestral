package gui.projetosemestral.componentes;

import java.awt.Image;

import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gui.projetosemestral.modelos.Filme;
import gui.projetosemestral.servicos.FilmeService;

public class BotoesDeAcao extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton botaoSalvar;
	private JButton botaoCancelar;
	
	private CamposCadastro camposCadastro;
	private CamposExtras camposExtras;
	private CampoImagem campoImagem;
	
	private FilmeService filmeService = new FilmeService();
	
	public BotoesDeAcao(CamposCadastro camposCadastro, CamposExtras camposExtras, CampoImagem campoImagem) {
		this.camposCadastro = camposCadastro;
		this.camposExtras = camposExtras;
		this.campoImagem = campoImagem;
		init();
	}
	
	private void init() {
		botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(acao -> {
			int confirma = JOptionPane.showConfirmDialog(null, "Deseja mesmo salvar?", "Salvar", JOptionPane.YES_NO_OPTION);
			switch (confirma) {
				case JOptionPane.YES_OPTION:
					String titulo = camposCadastro.getTituloCampo().getText();
					String sinopse = camposCadastro.getSinopseCampo().getText();
					String genero = (String) camposCadastro.getGeneroCampo().getSelectedItem();
					ButtonModel ondeAssistir = camposExtras.getOndeAssistirGrupo().getSelection();
					boolean assistido = camposExtras.getAssistido().isSelected();
					double avaliacao = camposExtras.getStarRater().getSelection();
					if (!titulo.isBlank()
							&& !sinopse.isBlank()
							&& ondeAssistir != null) {
						// atualizar o filme aqui, boa sorte jamaglian
						Filme filme = new Filme();
						filme.setAssistido(assistido);
						filme.setAvaliacao(avaliacao);
						filme.setGenero(genero);
						filme.setOndeAssistir(ondeAssistir.getActionCommand());
						filme.setSinopse(sinopse);
						filme.setTitulo(titulo);
						filme.setImagem(campoImagem.getImagemBase64());
						filmeService.cadastrar(filme);
						System.out.println(filme);
						limparCampos();
						JOptionPane.showMessageDialog(null, String.format("Filme %s salvo", titulo), "Salvo", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Algum campo está vazio", "Erro", JOptionPane.ERROR_MESSAGE);
					}
					break;
			}
		});
		
		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.addActionListener(acao -> {
			int confirma = JOptionPane.showConfirmDialog(null, "Deseja mesmo cancelar?", "Cancelar", JOptionPane.YES_NO_OPTION);
			switch (confirma) {
				case JOptionPane.YES_OPTION:
					limparCampos();
					break;
			}
		});
		
		add(botaoSalvar);
		add(botaoCancelar);
	}
	
	private void limparCampos() {
		camposCadastro.getCampoId().setText("");
		camposCadastro.getTituloCampo().setText("");
		camposCadastro.getSinopseCampo().setText("");
		
		camposExtras.getOndeAssistirGrupo().clearSelection();
		camposExtras.getAssistido().setSelected(false);
		
		camposExtras.getStarRater().setSelection(0);
		
		campoImagem.getBotaoImagem().setIcon(new ImageIcon(new ImageIcon("src/resources/noimage.png")
				.getImage().getScaledInstance(CampoImagem.LARGURA_IMAGEM, CampoImagem.ALTURA_IMAGEM, Image.SCALE_DEFAULT)));
		campoImagem.setImagemBase64(null);
	}

}
