package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VisitanteBean;
import daos.CadastrarVisitanteDao;


@WebServlet("/pages/PesquisarVisitante")
public class PesquisarVisitante extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public PesquisarVisitante() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String pesquisa = request.getParameter("pesquisa");

			if (pesquisa != null) {

				CadastrarVisitanteDao dao = new CadastrarVisitanteDao();

				List<VisitanteBean> pesquisaVisitante = dao.listarPesquisaVisitante(pesquisa);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrovisitante.jsp");
				request.setAttribute("visitantes", dao.listarPesquisaVisitante(pesquisa));
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
