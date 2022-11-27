package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Alumno;
import repository.AlumnoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/eliminarAlumno")
public class EliminarAlumno extends BaseServlet{

	AlumnoRepository repository = new AlumnoRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("item"));
	
		repository.delete(id);
		redirect(req, resp, "/index.jsp");
	}
	
	

}
