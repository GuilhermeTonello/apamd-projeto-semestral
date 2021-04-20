package gui.projetosemestral.componentes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import gui.projetosemestral.servicos.EncodeImageBase64Service;

/**
 * 
 * @author Guilherme Tonello
 *
 */
public class CampoImagem extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public static final int LARGURA_IMAGEM = 150;
	public static final int ALTURA_IMAGEM = 200;
	
	private String imagemBase64;
	private JButton botaoImagem;
	
	public CampoImagem() {
		setLayout(new GridBagLayout());
		init();
	}
	
	private void init() {
		GridBagConstraints gbc = new GridBagConstraints();
		botaoImagem = new JButton(new ImageIcon(new ImageIcon("src/resources/noimage.png").getImage().getScaledInstance(LARGURA_IMAGEM, ALTURA_IMAGEM, Image.SCALE_DEFAULT)));
		botaoImagem.addActionListener(acao -> {
			JFileChooser fileChooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png");
			fileChooser.setFileFilter(filter);
			int resultado = fileChooser.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				File arquivo = fileChooser.getSelectedFile();
				try {
					imagemBase64 = EncodeImageBase64Service.encodeFileToBase64Binary(arquivo);
					byte[] btDataFile = Base64.getDecoder().decode(imagemBase64);
					BufferedImage imagemDecodificada = ImageIO.read(new ByteArrayInputStream(btDataFile));
					botaoImagem.setIcon(new ImageIcon(new ImageIcon(imagemDecodificada).getImage().getScaledInstance(LARGURA_IMAGEM, ALTURA_IMAGEM, Image.SCALE_DEFAULT)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				imagemBase64 = null;
				botaoImagem.setIcon(new ImageIcon(new ImageIcon("src/resources/noimage.png").getImage().getScaledInstance(LARGURA_IMAGEM, ALTURA_IMAGEM, Image.SCALE_DEFAULT)));
			}
		});
		add(botaoImagem, gbc);
	}
	
	public String getImagemBase64() {
		return imagemBase64;
	}
	
	public void setImagemBase64(String imagemBase64) {
		this.imagemBase64 = imagemBase64;
	}
	
	public JButton getBotaoImagem() {
		return botaoImagem;
	}
	
}
