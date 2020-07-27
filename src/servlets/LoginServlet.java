package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoginBean;
import daos.CadastrarLoginDao;

@WebServlet("/pages/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// PARAMETROS PARA REALIZAR AÇÕES DE ELETAR ATUALIZAR E EXCLUIR E PESQUISAR
			CadastrarLoginDao dao = new CadastrarLoginDao();
			String acao = request.getParameter("acao");
			String usuario = request.getParameter("usuario");

			if (acao.equalsIgnoreCase("deletar")) {

				dao.deletarLogin(usuario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrologin.jsp");
				request.setAttribute("logins", dao.listarLogins());
				dispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("listartodos")) {

				dao.listarLogins();

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrologin.jsp");
				request.setAttribute("logins", dao.listarLogins());
				dispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("editar")) {

				LoginBean loginBean = dao.consultarAtualizarLogin(usuario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrologin.jsp");
				request.setAttribute("usuario", loginBean);
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// AQUI COMEÇA O CÓDIGO PARA IMPLEMENTAR O METODO DE SALVAR LOGIN ATUALIZAR E VALIDAR

			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");

			CadastrarLoginDao dao = new CadastrarLoginDao();
			LoginBean loginBean = new LoginBean();
			loginBean.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			
			loginBean.setLogin(login);
			loginBean.setSenha(senha);

			if (id == null || id.isEmpty() && dao.consultarLoginRepetido(login) ) {

				dao.cadastrarLogin(loginBean);

			} else {

				dao.atualizarLogin(loginBean);

				
			}

			// AQUI TERMINA O CÓDIGO PARA IMPLEMENTAR O METODO DE SALVAR LOGIN ATUALIZAR E VALIDAR
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		// AQUI COMEÇA O CÓDIGO PARA VISUALIZAR OS LOGINS CADASTRADOS
		try {
			CadastrarLoginDao dao = new CadastrarLoginDao();

			RequestDispatcher view = request.getRequestDispatcher("cadastrologin.jsp");

			request.setAttribute("logins", dao.listarLogins());

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// AQUI TERMINA O CÓDIGO PARA VISUALIZAR OS LOGINS CADASTRADOS

	}

}
