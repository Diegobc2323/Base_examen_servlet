package servlet;

import java.io.IOException;
import java.util.Optional;


import model.Alumno;
import model.Titulacion;
import model.Alumno_Titulacion;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Alumno getAlumnoFromRequest(HttpServletRequest req) {
		Alumno alumno = new Alumno();
		alumno.setNombre(req.getParameter("nombre"));
		System.out.println(alumno.getNombre());
		alumno.setEdad(Integer.parseInt(req.getParameter("edad")));
		System.out.println(alumno.getEdad());
		return alumno;
	}
	
	protected Alumno_Titulacion getAlumno_TitulacionFromRequest(HttpServletRequest req) {
		Alumno_Titulacion alumno_tit = new Alumno_Titulacion();
		alumno_tit.setId_titulacion(Integer.parseInt(req.getParameter("titulacion")));
		System.out.println(alumno_tit.getId_titulacion());
		alumno_tit.setId_alumno(Integer.parseInt(req.getParameter("alumno")));
		System.out.println(alumno_tit.getId_alumno());
		return alumno_tit;
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