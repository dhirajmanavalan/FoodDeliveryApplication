<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.res.DTO.Cart, com.res.DTO.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>

<style>

/* GLOBAL */
body {
    margin: 0;
    padding: 0;
    font-family: 'Arial', sans-serif;
    background: #f6f6f6;
}

/* HEADER */
h1 {
    text-align: center;
    background: #fc8019;
    color: white;
    padding: 20px;
    font-size: 30px;
    margin: 0;
}

/* CART CONTAINER */
.cart-container {
    width: 70%;
    margin: 30px auto;
}

/* CART CARD */
.cart-item {
    background: white;
    padding: 20px;
    border-radius: 12px;
    margin-bottom: 20px;
    box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
}

.cart-item h3 {
    margin: 0 0 10px 0;
    font-size: 22px;
}

.cart-item p {
    margin: 6px 0;
    font-size: 16px;
    color: #555;
    font-weight: 500;
}

/* QUANTITY CONTROLS */
.quantity-controls {
    display: flex;
    align-items: center;
    gap: 12px;
    margin-top: 10px;
}

.quantity-controls button {
    width: 36px;
    height: 36px;
    background: #fc8019;
    border: none;
    border-radius: 8px;
    color: white;
    font-size: 22px;
    cursor: pointer;
    transition: 0.2s ease;
}

.quantity-controls button:hover {
    background: #e46f0d;
}

.quantity-controls button:disabled {
    background: #bbb;
    cursor: not-allowed;
}

.quantity-number {
    font-size: 20px;
    font-weight: bold;
    min-width: 30px;
    text-align: center;
}

/* REMOVE BUTTON */
.remove-btn {
    margin-top: 15px;
    background: #ff4d4d;
    border: none;
    color: white;
    padding: 10px 16px;
    border-radius: 8px;
    cursor: pointer;
    font-weight: bold;
    transition: 0.2s ease;
}

.remove-btn:hover {
    background: #e60000;
}

/* EMPTY MESSAGE */
.empty-message {
    text-align: center;
    margin-top: 50px;
    font-size: 22px;
    color: #555;
    font-weight: bold;
}

/* ACTION BUTTONS */
.action-buttons {
    width: 70%;
    margin: 40px auto;
    text-align: center;
}

.action-btn {
    padding: 14px 30px;
    margin: 10px;
    border: none;
    border-radius: 10px;
    font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s ease;
}

.add-more-btn {
    background: #555;
    color: white;
}

.add-more-btn:hover {
    background: #333;
}

.checkout-btn {
    background: #28a745;
    color: white;
}

.checkout-btn:hover {
    background: #1f7e34;
}

</style>

</head>
<body>

<h1>Your Cart</h1>

<div class="cart-container">

<%
    Cart cart = (Cart) session.getAttribute("cart");
    Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");
%>

<%
    if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {

        for (CartItem item : cart.getItems().values()) {
%>

    <div class="cart-item">

        <h3><%= item.getName() %></h3>

        <p>Price: ₹ <%= item.getPrice() %></p>
        <p>Total: ₹ <%= item.getTotalPrice() %></p>

        <div class="quantity-controls">

            <!-- MINUS -->
            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                <button <% if (item.getQuantity() == 1) { %>disabled<% } %>>−</button>
            </form>

            <!-- QUANTITY -->
            <span class="quantity-number"><%= item.getQuantity() %></span>

            <!-- PLUS -->
            <form action="cart" method="post">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                <button>+</button>
            </form>

        </div>

        <!-- REMOVE -->
        <form action="cart" method="post">
            <input type="hidden" name="ite	mId" value="<%= item.getItemId() %>">
            <input type="hidden" name="action" value="remove">
            <button class="remove-btn">Remove</button>
        </form>

    </div>

<%
        }
    } else {
%>

    <p class="empty-message">Your cart is empty.</p>

<%
    }
%>

</div>

<!-- ACTION BUTTONS -->
<div class="action-buttons">

    <!-- ADD MORE ITEMS (ALWAYS VISIBLE) -->
    <form action="menu" method="get" style="display:inline;">
        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
        <button class="action-btn add-more-btn">Add More Items</button>
    </form>

    <% if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) { %>
        <!-- PROCEED TO CHECKOUT (SHOW ONLY IF CART NOT EMPTY) -->
        <form action="checkout.jsp" method="get" style="display:inline;">
            <button class="action-btn checkout-btn">Proceed To Checkout</button>
        </form>
    <% } %>

</div>


</body>
</html>
