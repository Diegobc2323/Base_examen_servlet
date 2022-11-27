package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Alumno_Titulacion;
import repository.Alumno_TitulacionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insertTitulacionAlumno")
public class InsertTitulacionAlumno extends BaseServlet{

	Alumno_TitulacionRepository repository = new Alumno_TitulacionRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Alumno_Titulacion alumno_tit = getAlumno_TitulacionFromRequest(req);
		System.out.println("hola "+alumno_tit.getId_alumno());
		
		repository.insert(alumno_tit);
		redirect(req, resp, "/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
