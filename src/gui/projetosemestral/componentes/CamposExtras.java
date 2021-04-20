package gui.projetosemestral.componentes;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CamposExtras extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ButtonGroup ondeAssistirGrupo;
	private JCheckBox assistido;
	private StarRater starRater;
	
	public CamposExtras() {
		setLayout(new GridLayout(7, 1));
		init();
	}
	
	private void init() {
		ondeAssistirGrupo = new ButtonGroup();
		
		JLabel  ondeAssistirTexto = new JLabel("Onde assistir");
		add(ondeAssistirTexto);
		
		String actionCommandNetflix = "Netflix";
		JRadioButton netflix = new JRadioButton(actionCommandNetflix);
		netflix.setActionCommand(actionCommandNetflix);
		ondeAssistirGrupo.add(netflix);
		add(netflix);
		
		String commandPrimeVideo = "Prime Video";
		JRadioButton primeVideo = new JRadioButton(commandPrimeVideo);
		primeVideo.setActionCommand(commandPrimeVideo);
		ondeAssistirGrupo.add(primeVideo);
		add(primeVideo);
		
		String commandPirateBay = "Pirate Bay";
		JRadioButton pirateBay = new JRadioButton(commandPirateBay);
		pirateBay.setActionCommand(commandPirateBay);
		ondeAssistirGrupo.add(pirateBay);
		add(pirateBay);
		
		assistido = new JCheckBox("Assistido");
		add(assistido);
		
		JLabel avaliacao = new JLabel("Avaliação");
		add(avaliacao);
		starRater = new StarRater(5);
		add(starRater);
	}

	public ButtonGroup getOndeAssistirGrupo() {
		return ondeAssistirGrupo;
	}

	public JCheckBox getAssistido() {
		return assistido;
	}
	
	public StarRater getStarRater() {
		return starRater;
	}

}
