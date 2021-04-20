package gui.projetosemestral.servicos;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

public class EncodeImageBase64Service {

	public static String encodeFileToBase64Binary(File arquivo) throws Exception {
		FileInputStream input = new FileInputStream(arquivo);
		byte[] bytes = new byte[(int) arquivo.length()];
		input.read(bytes);
		input.close();
		return new String(Base64.getEncoder().encode(bytes), "UTF-8");
	}

}
