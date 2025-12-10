package com.res.DAO;

import java.util.List;
import com.res.DTO.Menu;

public interface MenuDAO {

    List<Menu> getAllMenu();
    
    List<Menu> getAllMenu(int restaurant_id);

    Menu getMenu(int id);

    void addMenu(Menu menu);

    void updateMenu(Menu menu);

    void deleteMenu(int id);
}
