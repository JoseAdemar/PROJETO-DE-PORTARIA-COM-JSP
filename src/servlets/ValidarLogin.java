package servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;
import daos.CadastrarLoginDao;

@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ValidarLogin() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// SERVLET DE VALIDAÇÃO DE ACESSO AO SISTEMA 

		try {
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			
			CadastrarLoginDao dao = new CadastrarLoginDao();
			LoginBean loginBean = new LoginBean();

			loginBean.setLogin(login);
			loginBean.setSenha(senha);

			dao.validarAcessoLogin(login, senha);

			if (dao.validarAcessoLogin(login, senha)) {
				
				
				//COMEÇA O CODIGO DE SESSAO
				
				HttpSession sessao = request.getSession();
				
				sessao.setAttribute("usuAutenticado", loginBean);
				
				// TERMINA O CODIGO DE SESSAO

				response.sendRedirect("pages/menu.jsp");
				
				
			} else {
				
				response.sendRedirect("index.jsp");
				
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		// FIM DA SERVLET DE VALIDAÇÃO DE ACESSO AO SISTEMA 
	}

}
