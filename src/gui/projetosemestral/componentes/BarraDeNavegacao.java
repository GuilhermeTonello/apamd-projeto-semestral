package gui.projetosemestral.componentes;

import java.util.List;

import javax.swing.JComponent;
import javax.swing.JTabbedPane;

public class BarraDeNavegacao extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private List<String> tabs;
	private List<JComponent> components;
	
	public BarraDeNavegacao(List<String> tabs, List<JComponent> components) {
		this.tabs = tabs;
		this.components = components;
		init();
	}
	
	private void init() {
		if (tabs.size() != components.size()) {
			throw new RuntimeException("O número de tabs deve ser o mesmo de componentes");
		}
		for (int i = 0; i < tabs.size(); i++) {
			add(tabs.get(i), components.get(i));
		}
	}

}
