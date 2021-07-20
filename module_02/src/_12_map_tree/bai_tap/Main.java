package _12_map_tree.bai_tap;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();

        Product product1 = new Product(1, "Iphone", 30000);
        Product product2 = new Product(5, "Galaxy S10", 90000);
        Product product3 = new Product(4, "VSmart", 100000);
        Product product4 = new Product(7, "BPhone", 65000);

        productManager.arrayList.add(product1);
        productManager.arrayList.add(product2);
        productManager.arrayList.add(product3);
        productManager.arrayList.add(product4);

        productManager.displayProducts();
        productManager.remove(5);
        System.out.println("-------------------");
        System.out.println("Delete id=5");
        productManager.displayProducts();
        System.out.println("-------------------");
        System.out.println("Find Iphone");
        productManager.find("Iphone");
        System.out.println("-------------------");
        System.out.println("Sap xep gia tang dan");
        productManager.ascendingPrice();
        productManager.displayProducts();
        System.out.println("-------------------");
        System.out.println("Sap xep gia giam dan");
        productManager.decendingPrice();
        productManager.displayProducts();
    }
}
