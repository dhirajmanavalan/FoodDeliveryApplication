package com.res.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.res.Connector.ConnectorFactory;
import com.res.DAO.OrderDAO;
import com.res.DTO.Orders;

public class OrderDAOImp implements OrderDAO {

    private static final String GET_ALL = "SELECT * FROM orders";
    private static final String GET_ONE = "SELECT * FROM orders WHERE order_id=?";
    private static final String INSERT_SQL = 
        "INSERT INTO orders (order_date, restaurant_id, user_id, total_amount, paymethod_method, status, address) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_SQL = 
        "UPDATE orders SET order_date=?, restaurant_id=?, user_id=?, total_amount=?, paymethod_method=?, status=?, address=? WHERE order_id=?";
    private static final String DELETE_SQL = "DELETE FROM orders WHERE order_id=?";

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> list = new ArrayList<>();

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_ALL);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Orders o = new Orders(
                        rs.getInt("order_id"),
                        rs.getTimestamp("order_date"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("user_id"),
                        rs.getInt("total_amount"),
                        rs.getString("paymethod_method"),
                        rs.getString("status"),
                        rs.getString("address")
                );

                list.add(o);
            }

        } catch (Exception e) { e.printStackTrace(); }

        return list;
    }

    @Override
    public Orders getOrder(int id) {
        Orders order = null;

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_ONE)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                order = new Orders(
                        rs.getInt("order_id"),
                        rs.getTimestamp("order_date"),
                        rs.getInt("restaurant_id"),
                        rs.getInt("user_id"),
                        rs.getInt("total_amount"),
                        rs.getString("paymethod_method"),
                        rs.getString("status"),
                        rs.getString("address")
                );
            }

        } catch (Exception e) { e.printStackTrace(); }

        return order;
    }

    @Override
    public int addOrder(Orders order) {
    	int orderId = 0;
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setTimestamp(1, order.getOrder_date());
            pstmt.setInt(2, order.getRestaurant_id());
            pstmt.setInt(3, order.getUser_id());
            pstmt.setInt(4, order.getTotal_amount());
            pstmt.setString(5, order.getPaymethod_method());
            pstmt.setString(6, order.getStatus());
            pstmt.setString(7, order.getAddress());

            
            int affectedRows = pstmt.executeUpdate();
            if(affectedRows == 0)
            {
            	throw new SQLException("Creating order failed..");
            }
            
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if(generatedKeys.next()) {
            	orderId = generatedKeys.getInt(1);
            }
            else
            {
            	throw new SQLException("Creating order failed..");
            }

        } catch (Exception e) { e.printStackTrace();
        
        }
        return orderId;
        
    }

    @Override
    public void updateOrder(Orders order) {
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_SQL)) {

            pstmt.setTimestamp(1, order.getOrder_date());
            pstmt.setInt(2, order.getRestaurant_id());
            pstmt.setInt(3, order.getUser_id());
            pstmt.setInt(4, order.getTotal_amount());
            pstmt.setString(5, order.getPaymethod_method());
            pstmt.setString(6, order.getStatus());
            pstmt.setString(7, order.getAddress());
            pstmt.setInt(8, order.getOrder_id());

            pstmt.executeUpdate();
            System.out.println("Order Updated Successfully.");

        } catch (Exception e) { e.printStackTrace(); }
    }

    @Override
    public void deleteOrder(int id) {
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE_SQL)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Order Deleted Successfully.");

        } catch (Exception e) { e.printStackTrace(); }
    }
}
