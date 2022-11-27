package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Titulacion;
import repository.TitulacionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/insertTitulacion")
public class InsertTitulacionServlet extends BaseServlet{

	TitulacionRepository repository = new TitulacionRepository();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Titulacion titulacion = getTitulacionFromRequest(req);
		repository.insert(titulacion);
		redirect(req, resp, "/index.jsp");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
