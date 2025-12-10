# 🍽️ Food Delivery Application  
### A Complete Advanced Java (JSP + Servlets + JDBC + MySQL) Web Project

This is a fully functional **Food Delivery Web Application** built using **Advanced Java (J2EE)**.  
The project implements complete flow including restaurant listing, menu display, cart system, checkout, and order storage using MySQL.

---

## 🚀 Features

### ✅ **1. Restaurant Dashboard**
- Displays all restaurants dynamically from the database  
- Uses **RestaurantServlet** and **RestaurantDAO**  
- Clicking a restaurant loads its menu based on restaurant_id  

### ✅ **2. Menu Page**
- Menu items displayed dynamically using MenuServlet  
- Add-to-cart option for each menu item  
- Session-based cart storage  

### ✅ **3. Cart Management**
- Increase or decrease quantity  
- Remove item from cart  
- Add More Items → returns to the same restaurant’s menu  
- Auto-disable minus button when quantity = 1  

### ✅ **4. Checkout Page**
- Enter delivery address  
- Select payment method (Credit/Debit/UPI/COD)  
- Form validation on all fields  

### ✅ **5. Order Placement**
- Saves order details in **orders table**  
- Saves each item in **order_items table**  
- Clears cart after successful order  

### ✅ **6. Order Confirmation**
- Displays success message  
- Continue Browsing → returns to restaurant dashboard  

### ✅ **7. Backend Architecture**
- **JSP** for UI  
- **Servlets** for business logic  
- **DAO layer** for database operations  
- **DTO models** for data transfer  
- **ConnectorFactory** for DB connection pooling  
- Clean MVC structure  

---

## 🧱 Technologies Used

| Layer | Technology |
|-------|------------|
| Frontend | HTML, CSS, JSP |
| Backend | Java Servlets (J2EE) |
| Database | MySQL |
| Server | Apache Tomcat |
| Architecture | MVC |
| Build Tool | Eclipse Dynamic Web Project |

---

## 📂 Project Structure (MVC)


---

## 🗄️ Database Tables

### **restaurants**
Stores restaurant info

### **menu**
Menu items mapped with restaurant_id

### **orders**
Stores user order details  
Columns → order_id, order_date, restaurant_id, total_amount, payment_method, address

### **order_items**
Stores each ordered menu item with quantity and item_total

---

## 🔧 How to Run the Project

### 1️⃣ Import to Eclipse  
- File → Import → Dynamic Web Project  
- Add project to Apache Tomcat

### 2️⃣ Configure MySQL  
- Create database `restaurant`  
- Import table structure  
- Update DB credentials in `ConnectorFactory.java`

### 3️⃣ Run on Server  
- Right-click project → Run on Server  
- Open: http://localhost:8080/Food_Delivery_App/home


---

## 📝 Demo Video Script (Voice-over)
https://drive.google.com/drive/folders/1LaF1tjIjmPZ9XhX0bBkwwUWlFQUmCeLN?usp=drive_link

---

## 👨‍💻 Author

**Dhiraj Kumar**  
Software Developer | Java | Web Development | MySQL  

---

## ⭐ If You Like This Project
Please ⭐ **star** the repository — it motivates future development!

<p align="center">
  <img src="https://img.shields.io/badge/Food%20Delivery%20App-Advanced%20Java-orange?style=for-the-badge&logo=java&logoColor=white">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/JSP%20%7C%20Servlets%20%7C%20JDBC%20%7C%20MySQL%20%7C%20Tomcat-blue?style=for-the-badge">
</p>

<p align="center">
  A complete end-to-end food ordering system built using Java EE (JSP + Servlets), MySQL and MVC architecture.
</p>

