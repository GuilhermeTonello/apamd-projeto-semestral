package gui.projetosemestral.modelos;

public enum Genero {
	
	ACAO("Ação"),
	AVENTURA("Aventura"),
	COMEDIA("Comédia"),
	COMEDIA_ROMANTICA("Comédia romântica"),
	DOCUMENTARIO("Documentário"),
	DRAMA("Drama"),
	ESPIONAGEM("Espionagem"),
	FAROESTE("Faroeste"),
	FANTASIA("Fantasia"),
	FICCAO_CIENTIFICA("Ficção científica"),
	GUERRA("Guerra"),
	MUSICAL("Musical"),
	POLICIAL("Policial"),
	ROMANCE("Romance"),
	SERIADO("Seriado"),
	SUSPENSE("Suspense"),
	TERROR("Terror");
	
	private Genero(String genero) {
		this.genero = genero;
	}
	
	private String genero;
	
	public String getGenero() {
		return genero;
	}

}
