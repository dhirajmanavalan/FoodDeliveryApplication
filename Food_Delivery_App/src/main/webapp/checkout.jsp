<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>

body {
    font-family: Arial, sans-serif;
    background: #f5f5f5;
    margin: 0;
    padding: 0;
}

h1 {
    text-align: center;
    background: #fc8019;
    color: white;
    padding: 20px;
    margin: 0;
}

.checkout-container {
    width: 50%;
    margin: 40px auto;
    background: white;
    padding: 30px;
    border-radius: 12px;
    box-shadow: 0px 4px 14px rgba(0,0,0,0.1);
}

label {
    font-size: 17px;
    font-weight: bold;
    display: block;
    margin-bottom: 8px;
}

textarea {
    width: 100%;
    height: 120px;
    padding: 10px;
    font-size: 16px;
    border-radius: 8px;
    border: 1px solid #ccc;
    resize: none;
    margin-bottom: 20px;
}

select {
    width: 100%;
    padding: 12px;
    font-size: 16px;
    border-radius: 8px;
    border: 1px solid #ccc;
    margin-bottom: 25px;
}

.place-order-btn {
    width: 100%;
    background: #28a745;
    color: white;
    padding: 15px;
    border: none;
    border-radius: 10px;
    font-size: 20px;
    font-weight: bold;
    cursor: pointer;
    transition: 0.2s ease;
}

.place-order-btn:hover {
    background: #1f7e34;
}

</style>

</head>
<body>

<h1>Checkout</h1>

<div class="checkout-container">

    <form action="placeOrder" method="post">

        <!-- DELIVERY ADDRESS -->
        <label for="address">Delivery Address *</label>
        <textarea id="address" name="address" placeholder="Enter your full delivery address" required></textarea>

        <!-- PAYMENT METHOD -->
        <label for="payment">Payment Method *</label>
        <select id="payment" name="paymentMethod" required>
            <option value="">-- Select Payment Method --</option>
            <option value="Credit Card">Credit Card</option>
            <option value="Debit Card">Debit Card</option>
            <option value="UPI">UPI</option>
            <option value="Cash On Delivery">Cash On Delivery</option>
        </select>

        <!-- SUBMIT -->
        <button type="submit" class="place-order-btn">Place Order</button>
    </form>

</div>

</body>
</html>
