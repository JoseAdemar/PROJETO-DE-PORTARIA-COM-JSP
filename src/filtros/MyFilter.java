package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;

//@WebFilter(urlPatterns = {"/pages/*"})
@WebFilter(urlPatterns = {"/pages/*"})

public class MyFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {

			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession sessao = req.getSession();
			LoginBean loginBean = (LoginBean) sessao.getAttribute("usuAutenticado");

			if (loginBean == null ) {
				
				((HttpServletResponse) response).sendRedirect("../index.jsp");
				
								
				return;

			}
			
			chain.doFilter(request, response);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}  
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
