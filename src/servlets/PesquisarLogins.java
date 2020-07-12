package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LoginBean;
import daos.CadastrarLoginDao;

@WebServlet("/pages/PesquisarLogins")
public class PesquisarLogins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PesquisarLogins() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			String pesquisa = request.getParameter("pesquisa");

			if (pesquisa != null) {

				CadastrarLoginDao dao = new CadastrarLoginDao();

				List<LoginBean> pesquisaLogin = dao.listarPesquisaLogin(pesquisa);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrologin.jsp");
				request.setAttribute("logins", dao.listarPesquisaLogin(pesquisa));
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
