package gui.projetosemestral.componentes;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.stream.Stream;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import gui.projetosemestral.modelos.Genero;

public class CamposCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField tituloCampo;
	private JTextField sinopseCampo;
	private JComboBox<String> generoCampo;
	
	public CamposCadastro() {
		setLayout(new GridLayout(6, 1));
		init();
	}
	
	private void init() {
		JLabel tituloTexto = new JLabel("Título");
		tituloCampo = new JTextField();
		add(tituloTexto);
		add(tituloCampo);
		
		JLabel sinopseTexto = new JLabel("Sinopse");
		sinopseCampo = new JTextField();
		sinopseCampo.setBorder(new LineBorder(Color.WHITE, 0));
		add(sinopseTexto);
		add(sinopseCampo);
		
		JLabel generoTexto = new JLabel("Gênero");
		generoCampo = new JComboBox<>();
		Stream.of(Genero.values()).forEach(genero -> generoCampo.addItem(genero.getGenero()));
		
		add(generoTexto);
		add(generoCampo);
	}

	public JTextField getTituloCampo() {
		return tituloCampo;
	}

	public JTextField getSinopseCampo() {
		return sinopseCampo;
	}

	public JComboBox<String> getGeneroCampo() {
		return generoCampo;
	}

}
