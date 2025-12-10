package com.res.DAO;

import java.util.List;
import com.res.DTO.OrderItem;

public interface OrderItemDAO {

    void addOrderItem(OrderItem orderItem);

    List<OrderItem> getOrderItemsByOrderId(int orderId);

}
