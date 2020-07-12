package beans;

public class VisitanteBean {

	 // DECLARACAO DE ATRIBUTOS
	 private Long id;
	 private String nome;
	 private String cpf;
	 private String rg;
	 private String telefone;
	 private String datetime;
	 private String destino;
	 private String motivo;
	 private String foto;
	// private String typefoto;
	// FIM DA DECLARACAO DE ATRIBUTOS
	 
	 
	
	// METODOS GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getDatetime() {
		return datetime;
	}
	
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	//public String getTypefoto() {
		//return typefoto;
	//}
	//public void setTypefoto(String typefoto) {
		//this.typefoto = typefoto;
	//}
	
	// FIM DOS METODOS GETTERS AND SETTERS
	 
	 
	 
}
