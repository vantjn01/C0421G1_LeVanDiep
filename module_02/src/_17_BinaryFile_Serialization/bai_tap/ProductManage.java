package _17_BinaryFile_Serialization.bai_tap;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManage extends Product{
    ArrayList<Product> containsObject = new ArrayList<>();

    public void creatObject() {
        Product product1 = addProduct();
        Product product2 = new Product(2, "s10", "samsung", 15, "cell phone");
        containsObject.add(product2);
        Product product3 = new Product(3, "note8", "xiaomi", 5, "cell phone");
        containsObject.add(product3);
        Product product4 = new Product(4, "P30", "huawei", 40, "cell phone");
        containsObject.add(product3);
    }

    private Product inputFromKeyboard() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter brand name: ");
        String brandName = sc.nextLine();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter description: ");
        String description = sc.nextLine();

        return new Product(id, name, brandName, price, description);
    }

    public Product addProduct() {
        Product product;
        product = inputFromKeyboard();
        containsObject.add(product);
        return product;
    }

    public void writeToFile(ArrayList<Product> arrayList, String path) {
        FileOutputStream outputStream;
        ObjectOutputStream objectOutput = null;
        try {
            outputStream = new FileOutputStream(path);
            objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(arrayList);
            System.out.println("Successful writing.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage() + "/Error writing to file");
        } finally {
            try {
                if (objectOutput != null) {
                    objectOutput.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage() + "/Error closing file");
            }
        }
    }

    ArrayList<Product> FileToArrayList;

    public void readFromFile(String path) {
        FileInputStream inputStream;
        ObjectInputStream objectInput = null;
        try {
            inputStream = new FileInputStream(path);
            objectInput = new ObjectInputStream(inputStream);
            FileToArrayList = (ArrayList<Product>) objectInput.readObject();
            System.out.println("Successful reading.");
        } catch (IOException ex) {
            System.err.println(ex.getMessage() + "/Error reading file");
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage() + "/Class not found!");
        } finally {
            try {
                if (objectInput != null) {
                    objectInput.close();
                }
            } catch (IOException ex) {
                System.err.println(ex.getMessage() + "/Error closing file");
            }
        }
    }

    public void displayProduct() {
        try {
            for (Product elements : FileToArrayList) {
                System.out.println("ID: " + elements.getId() +
                        "\nName: " + elements.getName() +
                        "\nBrand: " + elements.getBrandName() +
                        "\nPrice: " + elements.getPrice() +
                        "\nDescription: " + elements.getDescription() + "\n");
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage() + "/File is empty!");
        }
    }

    public Product searchProduct(int id) {
        boolean matchId = false;
        Product temp = null;
        for (Product product : FileToArrayList) {
            if (product.getId() == id) {
                temp = product;
                matchId = true;
                break;
            }
        }
        if (matchId) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found!");
        }
        return temp;
    }
}
