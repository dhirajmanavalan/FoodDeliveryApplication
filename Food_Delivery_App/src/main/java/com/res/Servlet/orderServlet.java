package com.res.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.res.DAOImpl.OrderDAOImp;
import com.res.DAOImpl.OrderItemDAOImpl;
import com.res.DTO.Cart;
import com.res.DTO.CartItem;
import com.res.DTO.OrderItem;
import com.res.DTO.Orders;
import com.res.DTO.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/placeOrder")
public class orderServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Cart cart = (Cart)session.getAttribute("cart");
		int restaurantID = (int) session.getAttribute("oldRestaurantId");
		
		User user = (User) session.getAttribute("user");
		
		if(user==null)
		{
			RequestDispatcher rd = req.getRequestDispatcher("orderConfirm.jsp");
			rd.forward(req, resp);
		}
		
		if(cart != null && cart.getItems().isEmpty())
		{
			String address = req.getParameter("address");
			String paymentMethod = req.getParameter("paymentMethod");
			
			Orders orders = new Orders();
			orders.setUser_id(user.getUserId());
			orders.setRestaurant_id(restaurantID);
			orders.setOrder_date(new Timestamp(System.currentTimeMillis()));
			orders.setAddress(address);
			orders.setPaymethod_method(paymentMethod);
			orders.setStatus("Completed ");
			
			//calculate totalAmount
			int totalAmount = 0;
			
			for(CartItem cartItem  : cart.getItems().values()) {
				
				 int totalPrice = cartItem.getPrice() * cartItem.getQuantity();
				 totalAmount += totalPrice;
			}
			
			orders.setTotal_amount(totalAmount);
			int orderId = 0;
			
			OrderDAOImp orderDAOImp = new OrderDAOImp();
			
			 orderId = orderDAOImp.addOrder(orders);
			
			 OrderItem orderItem = new OrderItem();
			
			for(CartItem item  : cart.getItems().values()) {
				
				int itemId = item.getItemId();
				int quantity = item.getQuantity();
				int totalPrice = item.getTotalPrice();
				
				orderItem.setOrderId(orderId);
				orderItem.setMenuId(itemId);
				orderItem.setQuantity(quantity);
				orderItem.setItemTotal(totalPrice);
				
				 
				
			}
			
			OrderItemDAOImpl orderItemDAOImpl = new OrderItemDAOImpl();
			
			orderItemDAOImpl.addOrderItem(orderItem);
			
			session.removeAttribute("cart");
			
			resp.sendRedirect("OrderConfirm.jsp");
			
		}
		else
		{
			resp.sendRedirect("cart.jsp");
		}
			
		
		
	}

}
