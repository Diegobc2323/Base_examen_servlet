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
@WebServlet("/alumnoDto")
public class AlumnoDtoServlet extends BaseServlet{

	TitulacionRepository repository = new TitulacionRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Titulacion> titulacion = repository.listAll();
		HttpSession sesion = req.getSession(true);
		sesion.setAttribute("lista", titulacion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/insertarAlumnos.jsp");
		dispatcher.forward(req, resp);
	}

}