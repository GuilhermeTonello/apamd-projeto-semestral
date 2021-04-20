package gui.projetosemestral.modelos;

public class Filme {
	
	private Integer id;
	
	private String titulo;
	
	private String sinopse;
	
	private String genero;
	
	private String ondeAssistir;
	
	private Boolean assistido;
	
	private Double avaliacao;
	
	private String imagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getOndeAssistir() {
		return ondeAssistir;
	}

	public void setOndeAssistir(String ondeAssistir) {
		this.ondeAssistir = ondeAssistir;
	}

	public Boolean isAssistido() {
		return assistido;
	}

	public void setAssistido(Boolean assistido) {
		this.assistido = assistido;
	}
	
	public Double getAvaliacao() {
		return avaliacao;
	}
	
	public void setAvaliacao(Double avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Filme [titulo=" + titulo + ", sinopse=" + sinopse + ", genero=" + genero
				+ ", ondeAssistir=" + ondeAssistir + ", assistido=" + assistido + ", avaliacao=" + avaliacao + "]";
	}
	
}