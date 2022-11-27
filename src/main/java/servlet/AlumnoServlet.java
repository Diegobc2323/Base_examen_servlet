package servlet;

import java.io.IOException;
import java.util.Optional;


import model.Alumno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class AlumnoServlet extends HttpServlet {

	public AlumnoServlet() {
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

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}