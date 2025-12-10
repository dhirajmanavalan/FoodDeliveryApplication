package com.res.DAOImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.res.Connector.ConnectorFactory;
import com.res.DAO.MenuDAO;
import com.res.DTO.Menu;

public class MenuDAOImp implements MenuDAO {

	private static final String GET_MENU_BY_RESTAURANT = "SELECT * FROM menu WHERE menu_Restaurant_Id = ?";
    private static final String GET_ALL_MENU = "SELECT * FROM menu";
    private static final String GET_MENU = "SELECT * FROM menu WHERE menu_Id = ?";
    private static final String ADD_MENU = "INSERT INTO menu (menu_Name, menu_Price, menu_isAvailable, menu_imageURL, menu_Restaurant_Id) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_MENU = "UPDATE menu SET menu_Name=?, menu_Price=?, menu_isAvailable=?, menu_imageURL=?, menu_Restaurant_Id=? WHERE menu_Id=?";
    private static final String DELETE_MENU = "DELETE FROM menu WHERE menu_Id = ?";

    
    @Override
    public List<Menu> getAllMenu(int restaurant_id) {
        List<Menu> list = new ArrayList<>();

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_MENU_BY_RESTAURANT)) {

            pstmt.setInt(1, restaurant_id);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("menu_Id");
                String name = rs.getString("menu_Name");
                int price = rs.getInt("menu_Price");
                String available = rs.getString("menu_isAvailable");
                String img = rs.getString("menu_imageURL");
                int restId = rs.getInt("menu_Restaurant_Id");

                Menu menu = new Menu(id, name, price, available, img, restId);
                list.add(menu);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    
    @Override
    public List<Menu> getAllMenu() {
        List<Menu> list = new ArrayList<>();

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_ALL_MENU);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                int id = rs.getInt("menu_Id");
                String name = rs.getString("menu_Name");
                int price = rs.getInt("menu_Price");
                String available = rs.getString("menu_isAvailable");
                String img = rs.getString("menu_imageURL");
                int restId = rs.getInt("menu_Restaurant_Id");

                Menu m = new Menu(id, name, price, available, img, restId);
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Menu getMenu(int id) {
        Menu menu = null;

        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(GET_MENU)) {

            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                menu = new Menu(
                    rs.getInt("menu_Id"),
                    rs.getString("menu_Name"),
                    rs.getInt("menu_Price"),
                    rs.getString("menu_isAvailable"),
                    rs.getString("menu_imageURL"),
                    rs.getInt("menu_Restaurant_Id")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public void addMenu(Menu menu) {
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(ADD_MENU)) {

            pstmt.setString(1, menu.getMenu_Name());
            pstmt.setInt(2, menu.getMenu_Price());
            pstmt.setString(3, menu.getMenu_isAvailable());
            pstmt.setString(4, menu.getMenu_imageURL());
            pstmt.setInt(5, menu.getMenu_Restaurant_Id());

            pstmt.executeUpdate();
            System.out.println("Menu Added Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMenu(Menu menu) {
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU)) {

            pstmt.setString(1, menu.getMenu_Name());
            pstmt.setInt(2, menu.getMenu_Price());
            pstmt.setString(3, menu.getMenu_isAvailable());
            pstmt.setString(4, menu.getMenu_imageURL());
            pstmt.setInt(5, menu.getMenu_Restaurant_Id());
            pstmt.setInt(6, menu.getMenu_Id());

            pstmt.executeUpdate();
            System.out.println("Menu Updated Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu(int id) {
        try (Connection con = ConnectorFactory.requestConnection();
             PreparedStatement pstmt = con.prepareStatement(DELETE_MENU)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Menu Deleted Successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}
