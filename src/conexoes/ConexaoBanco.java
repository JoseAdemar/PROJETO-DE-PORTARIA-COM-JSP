package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {

	// ATRIBUTOS PARA A CONEXAO
	private static final String URL = "jdbc:mysql://localhost:3306/portaria?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USUARIO = "root";
	private static final String SENHA = "1234567";
	// FIM DOS ATRIBUTOS PARA A CONEXAO

	// METODO DE CONEXAO COM O BANCO MYSQL
	public static Connection conectarDB() {

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);

			return conexao;
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// FIM DO METODO DE CONEXAO COM O BANCO MYSQL

	// METODO MAIN PARA TESTAR SE A CONEXAO ESTÁ CERTA
	public static void main(String[] args) {

		try {
			new ConexaoBanco();
			Connection conexao = ConexaoBanco.conectarDB();

			if (conexao != null) {

				System.out.println("Conectado ao banco com sucesso");

			} else {

				System.out.println("Erro ao tentar conectar ao banco");

			}

		} catch (Exception e) {
 
			e.printStackTrace();

		}
	}
	// METODO MAIN PARA TESTAR SE A CONEXAO ESTÁ CERTA
}
