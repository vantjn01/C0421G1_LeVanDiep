package ketthucmodule2.models;



public abstract class Product {
    protected int id;
    protected String codeProduct;  // mã sp
    protected String nameProduct;
    protected double priceProduct;
    protected int quantityProduct;  // số lượng
    protected String manufacturer;  // nhà sản xuất

    public Product() {
    }

    public Product(int id, String codeProduct, String nameProduct, double priceProduct,
                   int quantityProduct, String manufacturer) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.quantityProduct = quantityProduct;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", codeProduct='" + codeProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", priceProduct='" + priceProduct + '\'' +
                ", quantityProduct='" + quantityProduct + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }

    public abstract void showInfo();
}
