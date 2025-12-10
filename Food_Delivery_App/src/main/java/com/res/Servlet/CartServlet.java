package com.res.Servlet;

import java.io.IOException;

import com.res.DAOImpl.MenuDAOImp;
import com.res.DTO.Cart;
import com.res.DTO.CartItem;
import com.res.DTO.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Forward GET calls to POST
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        // Retrieve or create cart
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Restaurant ID logic
        Integer oldRestaurantId = (Integer) session.getAttribute("oldRestaurantId");
        if (oldRestaurantId == null) oldRestaurantId = -1;

        String restParam = req.getParameter("restaurantId");
        int newRestaurantId = (restParam != null) ? Integer.parseInt(restParam) : oldRestaurantId;

        // Reset cart if user switches restaurants
        if (oldRestaurantId != newRestaurantId) {
            cart = new Cart();
            session.setAttribute("cart", cart);
            session.setAttribute("oldRestaurantId", newRestaurantId);
        }

        // Select action
        String action = req.getParameter("action");
        if (action == null) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        switch (action) {

        case "add":
            addItem(req, cart);
            break;

        case "update":
            updateItem(req, cart);
            break;

        case "remove":
            removeItem(req, cart);
            break;
        }

        resp.sendRedirect("cart.jsp");
    }

    private void addItem(HttpServletRequest req, Cart cart) {

        int menuId = Integer.parseInt(req.getParameter("menuId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        MenuDAOImp dao = new MenuDAOImp();
        Menu menu = dao.getMenu(menuId);

        CartItem item = new CartItem(menuId, menu.getMenu_Name(), menu.getMenu_Price(), quantity);
        cart.addCartItem(item);
    }

    private void updateItem(HttpServletRequest req, Cart cart) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        cart.updateCartItem(itemId, quantity);
    }

    private void removeItem(HttpServletRequest req, Cart cart) {

        int itemId = Integer.parseInt(req.getParameter("itemId"));
        cart.removeCartItem(itemId);
    }
}
