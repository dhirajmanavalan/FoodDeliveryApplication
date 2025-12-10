package com.res.DAO;

import java.util.List;
import com.res.DTO.Orders;

public interface OrderDAO {

    List<Orders> getAllOrders();

    Orders getOrder(int id);

    int addOrder(Orders order);

    void updateOrder(Orders order);

    void deleteOrder(int id);
}
