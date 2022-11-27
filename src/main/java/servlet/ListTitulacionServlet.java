package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Optional;



import model.Titulacion;
import repository.TitulacionRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/listTitulaciones")
public class ListTitulacionServlet extends BaseServlet{

	TitulacionRepository repository = new TitulacionRepository();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Titulacion> titulacion = repository.listAll();
		req.setAttribute("lista", titulacion);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listTitulaciones.jsp");
		dispatcher.forward(req, resp);
	}

}
