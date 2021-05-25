package gui.projetosemestral.janelas;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gui.projetosemestral.componentes.BotoesDeAcao;
import gui.projetosemestral.componentes.CampoImagem;
import gui.projetosemestral.componentes.CamposExtras;
import gui.projetosemestral.componentes.CamposCadastro;

public class JanelaCadastro extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private CampoImagem campoImagem;
	private CamposCadastro camposCadastro;
	private CamposExtras camposExtras;
	
	public JanelaCadastro() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(25);
		setLayout(borderLayout);
		init();
	}
	
	private void init() {
		campoImagem = new CampoImagem();
		add(campoImagem, BorderLayout.WEST);
		
		camposCadastro = new CamposCadastro();
        add(camposCadastro, BorderLayout.CENTER);
        
        camposExtras = new CamposExtras();
        add(camposExtras, BorderLayout.EAST);
        
        add(new BotoesDeAcao(camposCadastro, camposExtras, campoImagem), BorderLayout.SOUTH);
	}
	
	public CampoImagem getCampoImagem() {
		return campoImagem;
	}
	
	public CamposCadastro getCamposCadastro() {
		return camposCadastro;
	}
	
	public CamposExtras getCamposExtras() {
		return camposExtras;
	}
	
}
