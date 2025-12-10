package com.res.DTO;

public class Menu {

    private int menu_Id;
    private String menu_Name;
    private int menu_Price;
    private String menu_isAvailable;
    private String menu_imageURL;
    private int menu_Restaurant_Id;

    public Menu() {}

    // Constructor without ID (for insert)
    public Menu(String menu_Name, int menu_Price, String menu_isAvailable, 
                String menu_imageURL, int menu_Restaurant_Id) {
        this.menu_Name = menu_Name;
        this.menu_Price = menu_Price;
        this.menu_isAvailable = menu_isAvailable;
        this.menu_imageURL = menu_imageURL;
        this.menu_Restaurant_Id = menu_Restaurant_Id;
    }

    // Full constructor
    public Menu(int menu_Id, String menu_Name, int menu_Price, String menu_isAvailable,
                String menu_imageURL, int menu_Restaurant_Id) {
        this.menu_Id = menu_Id;
        this.menu_Name = menu_Name;
        this.menu_Price = menu_Price;
        this.menu_isAvailable = menu_isAvailable;
        this.menu_imageURL = menu_imageURL;
        this.menu_Restaurant_Id = menu_Restaurant_Id;
    }

    public int getMenu_Id() {
        return menu_Id;
    }

    public void setMenu_Id(int menu_Id) {
        this.menu_Id = menu_Id;
    }

    public String getMenu_Name() {
        return menu_Name;
    }

    public void setMenu_Name(String menu_Name) {
        this.menu_Name = menu_Name;
    }

    public int getMenu_Price() {
        return menu_Price;
    }

    public void setMenu_Price(int menu_Price) {
        this.menu_Price = menu_Price;
    }

    public String getMenu_isAvailable() {
        return menu_isAvailable;
    }

    public void setMenu_isAvailable(String menu_isAvailable) {
        this.menu_isAvailable = menu_isAvailable;
    }

    public String getMenu_imageURL() {
        return menu_imageURL;
    }

    public void setMenu_imageURL(String menu_imageURL) {
        this.menu_imageURL = menu_imageURL;
    }

    public int getMenu_Restaurant_Id() {
        return menu_Restaurant_Id;
    }

    public void setMenu_Restaurant_Id(int menu_Restaurant_Id) {
        this.menu_Restaurant_Id = menu_Restaurant_Id;
    }

    @Override
    public String toString() {
        return "Menu { " +
                "ID=" + menu_Id +
                ", Name='" + menu_Name + '\'' +
                ", Price=" + menu_Price +
                ", Available='" + menu_isAvailable + '\'' +
                ", ImageURL='" + menu_imageURL + '\'' +
                ", RestaurantID=" + menu_Restaurant_Id +
                " }";
    }
}
