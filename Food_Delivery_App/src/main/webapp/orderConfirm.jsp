<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmed</title>

<style>

body {
    margin: 0;
    padding: 0;
    font-family: 'Arial', sans-serif;
    background: #f6f6f6;
}

.container {
    width: 60%;
    margin: 60px auto;
    text-align: center;
    background: white;
    padding: 40px;
    border-radius: 16px;
    box-shadow: 0px 6px 20px rgba(0,0,0,0.15);
}

/* Tick Animation */
.tick {
    font-size: 100px;
    color: #28a745;
    animation: pop 0.4s ease-out;
}

@keyframes pop {
    0%   { transform: scale(0.2); opacity: 0; }
    100% { transform: scale(1); opacity: 1; }
}

h1 {
    font-size: 32px;
    color: #28a745;
    margin: 20px 0;
}

p {
    font-size: 18px;
    color: #555;
    margin-bottom: 40px;
}

/* BUTTON */
.btn {
    padding: 14px 28px;
    border: none;
    border-radius: 10px;
    font-size: 18px;
    font-weight: bold;
    cursor: pointer;
    transition: 0.3s ease;
}

.btn-home {
    background: #fc8019;
    color: white;
}

.btn-home:hover {
    background: #e66f12;
}

</style>

</head>
<body>

<div class="container">

    <div class="tick">✔</div>

    <h1>Thank You! 🎉</h1>
    <p>Your order has been successfully placed.</p>

    <!-- CONTINUE BROWSING ONLY -->
    <form action="home" method="get">
        <button class="btn btn-home">Continue Browsing</button>
    </form>

</div>

</body>
</html>
