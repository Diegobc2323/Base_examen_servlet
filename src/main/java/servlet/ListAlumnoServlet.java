package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Alumno;
import repository.AlumnoRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/listAlumno")
public class ListAlumnoServlet extends BaseServlet{

	AlumnoRepository repository = new AlumnoRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = repository.listAll();
		req.setAttribute("lista", alumnos);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listAlumnos.jsp");
		dispatcher.forward(req, resp);
	}

}
