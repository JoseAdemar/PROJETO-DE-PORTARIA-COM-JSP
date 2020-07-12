package beans;

public class LoginBean {

	// DECLARACAO DE ATRIBUTOS
	 private Long id;
	 private String login;
	 private String senha;
	// FIM DA DECLARACAO DE ATRIBUTOS
	 
	 
	// DECLARACAO DOS METODOS GETTERS AND SETTERS
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	 
    // FIM DA DECLARACAO DOS METODOS GETTERS AND SETTERS 
}
