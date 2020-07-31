package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.VisitanteBean;
import conexoes.ConexaoBanco;

public class CadastrarVisitanteDao {

	Connection conexao = ConexaoBanco.conectarDB();

	// METODO PARA CADASTRAR UM VISITANTE NO SISTEMA
	public void cadastrarVisitante(VisitanteBean dados) {

		try {

			String sql = "insert into visitante (nome,cpf,rg,telefone,datetime,destino,motivo,foto) values(?,?,?,?,?,?,?,?) ";

			PreparedStatement psm = conexao.prepareStatement(sql);

			psm.setString(1, dados.getNome());
			psm.setString(2, dados.getCpf());
			psm.setString(3, dados.getRg());
			psm.setString(4, dados.getTelefone());
			psm.setString(5, dados.getDatetime());
			psm.setString(6, dados.getDestino());
			psm.setString(7, dados.getMotivo());
			psm.setString(8, dados.getFoto());

			psm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	// FIM DO METODO PARA CADASTRAR UM VISITANTE NO SISTEMA

	// METODO PARA FAZER UPLOAD DA IMAGEM NO SISTEMA

	public void uploadFotoVisitante(String foto, String id) {
		try {
			String sql = "UPDATE VISITANTE \n" + "SET foto = ? \n" + "WHERE id = ? ";

			PreparedStatement psm = conexao.prepareStatement(sql);

			psm.setString(1, foto);
			psm.setString(2, id);

			psm.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}
	}
	// FIM DO METODO PARA FAZER UPLOAD DA IMAGEM NO SISTEMA

	// METODO PARA DELETAR UM VISITANTE

	public void deletarVisitante(String id) {

		try {

			String sql = "delete from visitante where id = '" + id + "'";

			PreparedStatement psm = conexao.prepareStatement(sql);

			psm.execute();
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	// FIM DO METODO PARA DELETAR UM VISITANTE

	// METODO PARA LISTAR OS DADOS CADASTRADO NO FORMULARIO VISITANTE E SER
	// VISUALIZADO
	// NO NAVEGADOR

	public List<VisitanteBean> listarVisitante() throws SQLException {

		List<VisitanteBean> listar = new ArrayList<VisitanteBean>();

		String sql = "select * from visitante Order by ID Desc";

		PreparedStatement psm = conexao.prepareStatement(sql);

		ResultSet rs = psm.executeQuery();

		while (rs.next()) {

			VisitanteBean visitante = new VisitanteBean();

			visitante.setId(rs.getLong("id"));
			visitante.setNome(rs.getString("nome"));
			visitante.setCpf(rs.getString("cpf"));
			visitante.setRg(rs.getString("rg"));
			visitante.setTelefone(rs.getString("telefone"));
			visitante.setDatetime(rs.getString("datetime"));
			visitante.setDestino(rs.getString("destino"));
			visitante.setMotivo(rs.getString("motivo"));
			visitante.setFoto(rs.getString("foto"));

			listar.add(visitante);

		}
		return listar;

		// FIM DO METODO PARA LISTAR OS DADOS CADASTRADO NO FORMULARIO VISITANTE E SER
		// VISUALIZADO NO NAVEGADOR

	}

	// INICIO DO METODO PARA REALIZAR CONSULTA / UTILIZADO TAMBÉM PARA O UPDATE
	public VisitanteBean consultarAtualizarVisitante(String usuario) {

		try {
			String sql = "select * from visitante where id = '" + usuario + "'";

			PreparedStatement psm = conexao.prepareStatement(sql);
			ResultSet rs = psm.executeQuery();

			if (rs.next()) {

				VisitanteBean visitante = new VisitanteBean();
				visitante.setId(rs.getLong("id"));
				visitante.setNome(rs.getString("nome"));
				visitante.setCpf(rs.getString("cpf"));
				visitante.setRg(rs.getString("rg"));
				visitante.setTelefone(rs.getString("telefone"));
				visitante.setDatetime(rs.getString("datetime"));
				visitante.setDestino(rs.getString("destino"));
				visitante.setMotivo(rs.getString("motivo"));
				visitante.setFoto(rs.getString("foto"));

				return visitante;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	// FIM DO METODO PARA REALIZAR CONSULTA / UTILIZADO TAMBÉM PARA O UPDATE

	// INICIO METODO PARA REALIZAR ATUALIZAÇÃO NO BANCO

	public void atualizarVisitante(VisitanteBean dados) {

		try {
			String sql = "update visitante set nome = ?, cpf = ?, rg = ?, telefone = ?, datetime = ?, destino = ?, motivo = ? where id = "
					+ dados.getId();
			PreparedStatement psm = conexao.prepareStatement(sql);
			psm.setString(1, dados.getNome());
			psm.setString(2, dados.getCpf());
			psm.setString(3, dados.getRg());
			psm.setString(4, dados.getTelefone());
			psm.setString(5, dados.getDatetime());
			psm.setString(6, dados.getDestino());
			psm.setString(7, dados.getMotivo());
			//psm.setString(8, dados.getFoto());

			psm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// FIM DO METODO PARA REALIZAR ATUALIZAÇÃO NO BANCO
	}

	// METODO PARA PESQUISAR VISITANTES JÁ EXISTENTES NO SISTEMA NO CAMPO PESQUISA
	public List<VisitanteBean> listarPesquisaVisitante(String pesquisa) throws SQLException {

		List<VisitanteBean> listaPesquisa = new ArrayList<VisitanteBean>();

		String sql = "select * from visitante where nome  like '%" + pesquisa + "%'";

		PreparedStatement psm = ConexaoBanco.conectarDB().prepareStatement(sql);
		ResultSet rs = psm.executeQuery();

		while (rs.next()) {

			VisitanteBean visitante = new VisitanteBean();

			visitante.setId(rs.getLong("id"));
			visitante.setNome(rs.getString("nome"));
			visitante.setCpf(rs.getString("cpf"));
			visitante.setRg(rs.getString("rg"));
			visitante.setTelefone(rs.getString("telefone"));
			visitante.setDatetime(rs.getString("datetime"));
			visitante.setDestino(rs.getString("destino"));
			visitante.setMotivo(rs.getString("motivo"));
			visitante.setFoto(rs.getString("foto"));

			listaPesquisa.add(visitante);

		}
		return listaPesquisa;

	}

	// FIM DO METODO PARA PESQUISAR VISITANTES JÁ EXISTENTES NO SISTEMA NO CAMPO
	// PESQUISA

	// INICIO DO METODO PARA VALIDAR LOGIN DUPLICADO

	public Boolean consultarVisitanteRepetido(String cpf) throws SQLException {

		String sql = "select count(1) as qtd from visitante where cpf = '" + cpf + "'";

		PreparedStatement psm = conexao.prepareStatement(sql);
		ResultSet rs = psm.executeQuery();

		if (rs.next()) {

			return rs.getInt("qtd") <= 0;

		}
		return false;
	}

	// FIM DO METODO PARA VALIDAR LOGIN DUPLICADO
}
