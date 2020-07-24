package servlets;



import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.VisitanteBean;
import daos.CadastrarVisitanteDao;


@WebServlet("/pages/VisitanteServlet")
public class VisitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VisitanteServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 		
		try {
			
			
			// PARAMETROS PARA REALIZAR AÇÕES DE ELETAR ATUALIZAR E EXCLUIR E PESQUISAR
			CadastrarVisitanteDao dao = new CadastrarVisitanteDao();
			String acao = request.getParameter("acao");
			String usuario = request.getParameter("usuario");

			if (acao.equalsIgnoreCase("deletar")) {

				dao.deletarVisitante(usuario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrovisitante.jsp");
				request.setAttribute("visitantes", dao.listarVisitante());
				dispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("listartodos")) {

				dao.listarVisitante();

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrovisitante.jsp");
				request.setAttribute("visitantes", dao.listarVisitante());
				dispatcher.forward(request, response);

			} else if (acao.equalsIgnoreCase("editar")) {

				VisitanteBean visitante = dao.consultarAtualizarVisitante(usuario);

				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrovisitante.jsp");
				request.setAttribute("usuario", visitante);
				dispatcher.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		try {
			
			
			// AQUI COME�A O C�DIGO PARA IMPLEMENTAR O METODO DE SALVAR VISITANTE ATUALIZAR E VALIDAR

			String id = request.getParameter("id");
			String nome = request.getParameter("nome");
			String cpf = request.getParameter("cpf");
			String rg = request.getParameter("rg");
			String telefone = request.getParameter("telefone");
			String datetime = request.getParameter("datetime");
			String destino = request.getParameter("destino");
			String motivo = request.getParameter("motivo");
			String foto = request.getParameter("foto");
			//System.out.println(foto);
			//String typefoto = request.getParameter("typefoto");


			CadastrarVisitanteDao dao = new CadastrarVisitanteDao();
			VisitanteBean visitante = new VisitanteBean();


			if (foto != null) {
				dao.uploadFotoVisitante(foto, id);
			} else {
				//visitante.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
				visitante.setId(id != null && id != "" ? Long.parseLong(id) : 0);
				visitante.setNome(nome);
				visitante.setCpf(cpf);
				visitante.setRg(rg);
				visitante.setTelefone(telefone);
				visitante.setDatetime(datetime);
				visitante.setDestino(destino);
				visitante.setMotivo(motivo);
				visitante.setFoto(foto);
				//visitante.setTypefoto(typefoto);


				if (id == null || id.isEmpty() && dao.consultarVisitanteRepetido(cpf)) {

					dao.cadastrarVisitante(visitante);

				} else {

					dao.atualizarVisitante(visitante);


				}
			}


			// AQUI TERMINA O C�DIGO PARA IMPLEMENTAR O METODO DE SALVAR VISITANTE ATUALIZAR E VALIDAR
		} catch (Exception e) {
			e.printStackTrace();

		}

		// AQUI COME�A O C�DIGO PARA VISUALIZAR OS VISITANTES CADASTRADOS
		try {
			CadastrarVisitanteDao dao = new CadastrarVisitanteDao();

			RequestDispatcher view = request.getRequestDispatcher("cadastrovisitante.jsp");

			request.setAttribute("visitantes", dao.listarVisitante());

			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// AQUI TERMINA O C�DIGO PARA VISUALIZAR OS VISITANTES CADASTRADOS


	}

}
