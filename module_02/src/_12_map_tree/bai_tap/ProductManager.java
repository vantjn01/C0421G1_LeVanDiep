package _12_map_tree.bai_tap;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProductManager  {
    ArrayList<Product> arrayList = new ArrayList<>();

    public ProductManager() {

    }

    ;

    public void add() {
        Product product = new Product();
        product.inputValue();
        arrayList.add(product);
    }

    public void edit(int id) {
        for (Product product : arrayList) {
            if (product.getId() == id) {
                product.inputValue();
            }
        }
    }

    public void remove(int id) {
        int temp = 0;
        for (Product product : arrayList) {
            if (product.getId() == id) {
                arrayList.remove(temp);
                break;
            }
            temp++;
        }
    }

    public void find(String name) {
        int temp = 0;
        for (Product product : arrayList) {
            if (product.getName().equals(name)) {
                System.out.println(product.toString());
            }
            temp++;
        }
    }

    public void displayProducts() {
        for (Product product : arrayList) {
            System.out.println(product.toString() + "\n");
        }
    }

    public void ascendingPrice() {
        Collections.sort(arrayList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
    public void decendingPrice(){
        Collections.sort(arrayList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return 1;
                } else if (o1.getPrice() == o2.getPrice()){
                    return 0;
                } else {
                    return -1;
                }
            }
        });
    }
}
