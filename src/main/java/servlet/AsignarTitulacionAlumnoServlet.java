package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Alumno;
import repository.AlumnoRepository;
import model.Titulacion;
import repository.TitulacionRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/asigTitulaciones")
public class AsignarTitulacionAlumnoServlet extends BaseServlet{

	TitulacionRepository repository_titulacion = new TitulacionRepository();
	AlumnoRepository repository_alumno = new AlumnoRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Titulacion> titulacion = repository_titulacion.listAll();
		List<Alumno> alumnos = repository_alumno.listAll();
		HttpSession sesion = req.getSession(true);
		sesion.setAttribute("titulaciones", titulacion);
		sesion.setAttribute("alumnos", alumnos);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/asignarTitulacionesAlumno.jsp");
		dispatcher.forward(req, resp);
	}

}