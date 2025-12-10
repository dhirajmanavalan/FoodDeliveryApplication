package com.res.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.res.Connector.ConnectorFactory;
import com.res.DAO.OrderItemDAO;
import com.res.DTO.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO {

    private static final String INSERT_ORDER_ITEM =
        "INSERT INTO order_items (order_id, menu_id, quantity, item_total) VALUES (?, ?, ?, ?)";

    private static final String GET_ORDER_ITEMS =
        "SELECT * FROM order_items WHERE order_id = ?";

    @Override
    public void addOrderItem(OrderItem orderItem) {

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER_ITEM)) {

            pstmt.setInt(1, orderItem.getOrderId());
            pstmt.setInt(2, orderItem.getMenuId());
            pstmt.setInt(3, orderItem.getQuantity());
            pstmt.setInt(4, orderItem.getItemTotal());

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(int orderId) {

        List<OrderItem> list = new ArrayList<>();

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_ORDER_ITEMS)) {

            pstmt.setInt(1, orderId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                OrderItem item = new OrderItem(
                    rs.getInt("orderItem_id"),
                    rs.getInt("order_id"),
                    rs.getInt("menu_id"),
                    rs.getInt("quantity"),
                    rs.getInt("item_total")
                );

                list.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
