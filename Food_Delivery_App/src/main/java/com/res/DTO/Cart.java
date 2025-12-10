package com.res.DTO;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    public void addCartItem(CartItem item) {
        int id = item.getItemId();

        if (items.containsKey(id)) {
            CartItem existing = items.get(id);
            existing.setQuantity(existing.getQuantity() + item.getQuantity());
        } else {
            items.put(id, item);
        }
    }

    public void updateCartItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                items.get(itemId).setQuantity(quantity);
            }
        }
    }

    public void removeCartItem(int itemId) {
        items.remove(itemId);
    }

    public void clear() {
        items.clear();
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return items.values()
                .stream()
                .mapToDouble(i -> i.getPrice() * i.getQuantity())
                .sum();
    }
}
