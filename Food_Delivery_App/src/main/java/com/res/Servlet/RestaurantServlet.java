package com.res.Servlet;

import java.io.IOException;
import java.util.List;

import com.res.DAOImpl.RestaurantDAOImp;
import com.res.DTO.Restaurant;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class RestaurantServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAOImp impl = new RestaurantDAOImp();
		List<Restaurant> getallRestaurants = impl.getallRestaurants(null);
		
		
		req.setAttribute("getallRestaurants", getallRestaurants);
		
		RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
		rd.forward(req, resp);
	
		
		
	}

}
