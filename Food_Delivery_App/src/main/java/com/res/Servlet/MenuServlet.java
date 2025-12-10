package com.res.Servlet;

import java.io.IOException;
import java.util.List;

import com.res.DAOImpl.MenuDAOImp;
import com.res.DTO.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MenuDAOImp impl = new MenuDAOImp();

		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
		List<Menu> allMenu = impl.getAllMenu(restaurantId);
		
		
		
		req.setAttribute("allMenu", allMenu);
		
		RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
		rd.forward(req, resp);
		
	
	}

}
