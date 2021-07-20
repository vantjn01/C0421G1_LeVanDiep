package _17_BinaryFile_Serialization.bai_tap;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;      // mã sản phẩm
    private String name; // tên sản phẩm
    private String brandName;        // tên hãng
    private int price;            // giá sp
    private String description;      // miêu tả khác
    public Product(){

    }

    public Product(int id, String name, String brandName, int price, String description) {
        this.id = id;
        this.name = name;
        this.brandName = brandName;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brandName='" + brandName + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
