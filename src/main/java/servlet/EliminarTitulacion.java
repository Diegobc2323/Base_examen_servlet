package servlet;

import java.io.IOException;
import java.util.Optional;



import model.Titulacion;
import repository.TitulacionRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/eliminarTitulacion")
public class EliminarTitulacion extends BaseServlet{

	TitulacionRepository repository = new TitulacionRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("item"));
	
		repository.delete(id);
		redirect(req, resp, "/index.jsp");
	}
	
	

}
