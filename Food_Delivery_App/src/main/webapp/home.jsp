<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.List,com.res.DTO.Restaurant"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurants</title>
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
            font-size: 28px;
            font-weight: bold;
            text-align: center;
        }

        .container {
            padding: 30px;
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            grid-gap: 25px;
        }

        .card {
            background: white;
            border-radius: 12px;
            overflow: hidden;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
            transition: 0.3s ease;
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 6px 14px rgba(0,0,0,0.15);
        }

        .card img {
            width: 100%;
            height: 180px;
            object-fit: cover;
        }

        .content {
            padding: 15px;
        }

        .title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .desc {
            font-size: 14px;
            color: #555;
            margin-bottom: 8px;
        }

        .info {
            font-size: 14px;
            margin-bottom: 5px;
        }

        .rating {
            background: #48c479;
            color: white;
            padding: 4px 8px;
            border-radius: 6px;
            display: inline-block;
            font-weight: bold;
            margin-bottom: 8px;
        }

        .active {
            font-weight: bold;
            color: green;
        }

        .inactive {
            font-weight: bold;
            color: red;
            
            
        }
    </style>
</head>

<body>
    <div class="header">Top Restaurants Near You</div>

    <div class="container">
    
    <% 
    List<Restaurant> getallRestaurants = (List<Restaurant>) request.getAttribute("getallRestaurants");
    for (Restaurant res : getallRestaurants) {
    %>
    	<a href="menu?restaurantId=<%= res.getRestaurant_id() %>" style="text-decoration: none; color: inherit;">
    <div class="card">
        
        <img src="<%= res.getRestaurant_imageurl() %>" alt="Restaurant Image">

        <div class="content">

            <div class="title"><%= res.getRestaurant_name() %></div>

            <div class="rating">
                <b>Rating:</b>★ <%= res.getRestaurant_rating() %> 
            </div>

            <div class="desc"><%= res.getRestaurant_description() %></div>

            <div class="info">
                <b>Cuisine:</b> <%= res.getRestaurant_cuisine() %>
            </div>

            <div class="info">
                <b>Address:</b> <%= res.getRestaurant_address() %>
            </div>

            <div class="info">
                <b>Delivery Time:</b> <%= res.getRestaurant_delivery_time() %> 
            </div>

            <div class="info">
                <b>Status:</b>
                <span class="<%= res.getRestaurant_isactive().equalsIgnoreCase("active") ? "active" : "inactive" %>">
                    <%= res.getRestaurant_isactive() %>
                </span>
            </div>

        </div>
    </div>
</a>

    <%
	}
    
    %>

        

      
    </div>
</body>
</html>
