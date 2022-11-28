package servlet;

import java.io.IOException;
import java.util.Optional;


import model.Champions;
import model.Items;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class BaseServlet extends HttpServlet {

	public BaseServlet() {
		super();
	}

	protected Champions getChampionFromRequest(HttpServletRequest req) {
		Champions champion = new Champions();
		champion.setId(Integer.parseInt(req.getParameter("id")));
		champion.setChampion_name(req.getParameter("champion_name"));
		champion.setTitle(req.getParameter("title"));
		champion.setLore(req.getParameter("lore"));
		champion.setTags(req.getParameter("tags"));
		
		
		System.out.println(champion.getId());
		System.out.println(champion.getChampion_name());
		System.out.println(champion.getTitle());
		System.out.println(champion.getLore());
		System.out.println(champion.getTags());
		
		
		return champion;
		
	}
	
	protected Items getItemFromRequest(HttpServletRequest req) {
		Items item = new Items();
		item.setItem_name(req.getParameter("item_name"));
		item.setEffect(req.getParameter("effect"));

		
		return item;
		
	}
	
	

	protected void redirect(HttpServletRequest req, HttpServletResponse resp, String jsp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(req, resp);
	}

}