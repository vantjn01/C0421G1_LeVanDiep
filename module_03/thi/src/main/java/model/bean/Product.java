package model.bean;

public class Product {
    private int id;
    private String product_name;
    private double price;
    private int quantity;
    private String color;
    private String category;
//    private String action;

    public Product(int id, String product_name, double price, int quantity, String color, String category) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
//        this.action = action;
    }

    public Product(String product_name, double price, int quantity, String color, String category) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
//        this.action = action;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setStt(int stt) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

//    public String getAction() {
//        return action;
//    }
//
//    public void setAction(String action) {
//        this.action = action;
//    }
}
