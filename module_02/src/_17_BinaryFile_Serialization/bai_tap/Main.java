package _17_BinaryFile_Serialization.bai_tap;

public class Main {
    public static void main(String[] args) {
        ProductManage productManage = new ProductManage();

        productManage.creatObject();

        String path = "H:\\C0421G1_LeVanDiep\\module_02\\src\\_17_BinaryFile_Serialization\\bt1.txt";
        productManage.writeToFile(productManage.containsObject, path);

        productManage.readFromFile(path);

        productManage.displayProduct();

        Product searchById = productManage.searchProduct(3);

        System.out.println(searchById.toString());
    }
}
