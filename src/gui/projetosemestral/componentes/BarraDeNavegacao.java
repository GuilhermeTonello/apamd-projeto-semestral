package gui.projetosemestral.componentes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class BarraDeNavegacao extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private List<String> tabs;
	private List<JComponent> componentes;
	
	public BarraDeNavegacao(List<String> tabs, List<JComponent> componentes) {
		this.tabs = tabs;
		this.componentes = componentes;
		init();
	}
	
	private void init() {
		if (tabs.size() != componentes.size()) {
			throw new RuntimeException("O número de tabs deve ser o mesmo de componentes");
		}
		for (int i = 0; i < tabs.size(); i++) {
			add(tabs.get(i), componentes.get(i));
		}
	}
	
	public List<String> getTabs() {
		return tabs;
	}

	public List<JComponent> getComponentes() {
		return componentes;
	}

}
