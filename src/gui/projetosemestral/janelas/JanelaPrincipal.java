package gui.projetosemestral.janelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

import gui.projetosemestral.componentes.BarraDeNavegacao;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static BarraDeNavegacao nav;
	
	public static final int LARGURA = 650;
	public static final int ALTURA = 330;
	
	public JanelaPrincipal() {
		super("Projeto Semestral - Guilherme Tonello - RM:82048");
		init();
		config();
	}
	
	private void init() {
		List<String> tabs = new ArrayList<>();
		tabs.add("Cadastro");
		tabs.add("Lista");
		
		List<JComponent> components = new ArrayList<>();
		components.add(new JanelaCadastro());
		components.add(new JanelaLista());
		
		nav = new BarraDeNavegacao(tabs, components);
		nav.addChangeListener(change -> {
			nav.setComponentAt(1, new JanelaLista());
		});
		
		add(nav);
	}
	
	private void config() {
		setSize(LARGURA, ALTURA);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}
