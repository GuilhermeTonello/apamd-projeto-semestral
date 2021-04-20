package gui.projetosemestral;

import gui.projetosemestral.database.config.DatabaseDDL;
import gui.projetosemestral.janelas.JanelaPrincipal;

public class ProjetoSemestralApplication {
	
	public static void main(String[] args) {
		DatabaseDDL.createTable();
		new JanelaPrincipal();
	}
	
}
