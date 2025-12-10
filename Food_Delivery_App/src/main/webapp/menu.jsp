<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.res.DTO.Menu"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Restaurant Menu</title>

<style>
body {
    margin: 0;
    padding: 0;
    font-family: Arial, sans-serif;
    background: #f6f6f6;
}

.header {
    background: #fc8019;
    color: white;
    padding: 20px;
    text-align: center;
    font-size: 28px;
    font-weight: bold;
}

.container {
    padding: 30px;
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
    grid-gap: 25px;
}

.menu-card {
    background: white;
    border-radius: 12px;
    overflow: hidden;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    transition: 0.3s ease;
}

.menu-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 6px 14px rgba(0, 0, 0, 0.15);
}

.menu-card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
}

.menu-content {
    padding: 15px;
}

.menu-title {
    font-size: 20px;
    font-weight: bold;
    margin-bottom: 5px;
}

.price {
    font-size: 18px;
    font-weight: bold;
    margin-bottom: 8px;
    color: #333;
}

.availability {
    font-size: 14px;
    margin-bottom: 10px;
}

.available {
    color: green;
    font-weight: bold;
}

.not-available {
    color: red;
    font-weight: bold;
}

.add-btn {
    width: 100%;
    background: #fc8019;
    color: white;
    border: none;
    padding: 12px;
    font-size: 16px;
    font-weight: bold;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s ease;
}

.add-btn:hover {
    background: #e46f0d;
}
</style>

</head>

<body>

<div class="header">Menu Items</div>

<div class="container">

<%
    List<Menu> allMenu = (List<Menu>) request.getAttribute("allMenu");

    if (allMenu != null) {
        for (Menu menu : allMenu) {
%>

    <div class="menu-card">
        <img src="<%= menu.getMenu_imageURL() %>" alt="Menu Image">

        <div class="menu-content">
            <div class="menu-title"><%= menu.getMenu_Name() %></div>
            <div class="price">₹ <%= menu.getMenu_Price() %></div>

            <div class="availability">
                Status:
                <span class="<%= menu.getMenu_isAvailable().equalsIgnoreCase("Yes") ? "available" : "not-available" %>">
                    <%= menu.getMenu_isAvailable() %>
                </span>
            </div>

            <!-- ADD TO CART FORM -->
            <form action="cart" method="post">
                <input type="hidden" name="restaurantId" value="<%= menu.getMenu_Restaurant_Id() %>">
                <input type="hidden" name="menuId" value="<%= menu.getMenu_Id() %>">
                <input type="hidden" name="quantity" value="1">
                <input type="hidden" name="action" value="add">

                <button type="submit" class="add-btn">ADD TO CART</button>
            </form>
        </div>
    </div>

<%
        }
    }
%>

</div>

</body>
</html>
