package servlet;

import java.io.IOException;
import java.util.Optional;


import model.Titulacion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class TitulacionServlet extends HttpServlet {

	public TitulacionServlet() {
		super();
	}

	protected Titulacion getTitulacionFromRequest(HttpServletRequest req) {
		Titulacion titulacion = new Titulacion();
		titulacion.setTitulo(req.getParameter("titulo"));
		System.out.println(titulacion.getTitulo());
		return titulacion;
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}