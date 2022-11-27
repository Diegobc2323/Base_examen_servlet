package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Alumno;
import repository.AlumnoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insertAlumno")
public class InsertAlumnoServlet extends BaseServlet{

	AlumnoRepository repository = new AlumnoRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Alumno alumno = getAlumnoFromRequest(req);
	
		repository.insert(alumno);
		redirect(req, resp, "/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
