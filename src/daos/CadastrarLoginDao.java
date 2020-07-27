package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.LoginBean;
import conexoes.ConexaoBanco;

public class CadastrarLoginDao {

	Connection conexao = ConexaoBanco.conectarDB();

	public CadastrarLoginDao() {

	}

	// METODO PARA CADASTRAR UM USUARIO PARA FAZER LOGIN NO SISTEMA
	public void cadastrarLogin(LoginBean acesso) {

		try {

			String sql = "insert into acesso (login,senha) values(?,?) ";

			PreparedStatement psm = conexao.prepareStatement(sql);

			psm.setString(1, acesso.getLogin());
			psm.setString(2, acesso.getSenha());

			psm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// FIM DO METODO PARA CADASTRAR UM USUARIO PARA FAZER LOGIN NO SISTEMA

	// METODO PARA DELETAR UM LOGIN

	public void deletarLogin(String id) {

		try {

			String sql = "delete from acesso where id = '" + id + "'";

			PreparedStatement psm = conexao.prepareStatement(sql);

			psm.execute();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// FIM DO METODO PARA DELETAR UM LOGIN

	// METODO PARA LISTAR OS DADOS CADASTRADO NO FORMULARIO LOGIN E SER VISUALIZADO
	// NO NAVEGADOR

	public List<LoginBean> listarLogins() throws SQLException {

		List<LoginBean> listar = new ArrayList<LoginBean>();

		String sql = "select * from acesso";

		PreparedStatement psm = conexao.prepareStatement(sql);

		ResultSet rs = psm.executeQuery();

		while (rs.next()) {

			LoginBean loginBean = new LoginBean();

			loginBean.setId(rs.getLong("id"));
			loginBean.setLogin(rs.getString("login"));
			loginBean.setSenha(rs.getString("senha"));

			listar.add(loginBean);

		}
		return listar;

		// FIM DO METODO PARA LISTAR OS DADOS CADASTRADO NO FORMULARIO LOGIN E SER
		// VISUALIZADO NO NAVEGADOR

	}

	// INICIO DO METODO PARA REALIZAR CONSULTA / UTILIZADO TAMBÉM PARA O UPDATE
	public LoginBean consultarAtualizarLogin(String usuario) {

		try {
			String sql = "select * from acesso where id = '" + usuario + "'";

			PreparedStatement psm = conexao.prepareStatement(sql);
			ResultSet rs = psm.executeQuery();

			if (rs.next()) {

				LoginBean loginBean = new LoginBean();
				loginBean.setId(rs.getLong("id"));
				loginBean.setLogin(rs.getString("login"));
				loginBean.setSenha(rs.getString("senha"));

				return loginBean;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	// FIM DO METODO PARA REALIZAR CONSULTA / UTILIZADO TAMBÉM PARA O UPDATE

	// INICIO METODO PARA REALIZAR ATUALIZAÇÃO NO BANCO

	public void atualizarLogin(LoginBean login) {

		try {
			String sql = "update acesso set login = ?, senha = ? where id = " + login.getId();
			PreparedStatement psm = conexao.prepareStatement(sql);
			psm.setString(1, login.getLogin());
			psm.setString(2, login.getSenha());

			psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// FIM DO METODO PARA REALIZAR ATUALIZAÇÃO NO BANCO
	}

	// METODO PARA PESQUISAR LOGINS JÁ EXISTENTES NO SISTEMA NO CAMPO PESQUISA
	public List<LoginBean> listarPesquisaLogin(String pesquisa) throws SQLException {

		List<LoginBean> listaPesquisa = new ArrayList<LoginBean>();

		String sql = "select * from acesso where login  like '%" + pesquisa + "%'";

		PreparedStatement psm = ConexaoBanco.conectarDB().prepareStatement(sql);
		ResultSet rs = psm.executeQuery();

		while (rs.next()) {

			LoginBean loginBean = new LoginBean();

			loginBean.setId(rs.getLong("id"));
			loginBean.setLogin(rs.getString("login"));
			loginBean.setSenha(rs.getString("senha"));

			listaPesquisa.add(loginBean);

		}
		return listaPesquisa;

	}

	// FIM DO METODO PARA PESQUISAR LOGINS JÁ EXISTENTES NO SISTEMA NO CAMPO PESQUISA
	
	
	// INICIO DO METODO PARA VALIDAR LOGIN DUPLICADO

	public Boolean consultarLoginRepetido(String login) throws SQLException {

		String sql = "select count(1) as qtd from acesso where login = '" + login + "'";

		PreparedStatement psm = conexao.prepareStatement(sql);
		ResultSet rs = psm.executeQuery();

		if (rs.next()) {

			return rs.getInt("qtd") <= 0;

		}
		return false;
	}
	
	// FIM DO METODO PARA VALIDAR LOGIN DUPLICADO

	
	// METODO PARA VALIDAR O ACESSO DE LOGIN AO SISTEMA
	public boolean validarAcessoLogin(String login, String senha) throws SQLException{
		
		String sql = "select * from acesso where login = '" + login + "'  and senha = '" + senha + "'";
		
		PreparedStatement psm = ConexaoBanco.conectarDB().prepareStatement(sql);
		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next()) {
			
			return true;
						
		} else {
			
			return false;
		}
		
	}
	// FIM DO METODO PARA VALIDAR O ACESSO DE LOGIN AO SISTEMA
	
}
