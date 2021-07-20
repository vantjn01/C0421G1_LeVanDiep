package ketthucmodule2.controller;

import ketthucmodule2.commons.FileUtils;
import ketthucmodule2.commons.Validates;
import ketthucmodule2.models.ExportProducts;
import ketthucmodule2.models.ImportedProducts;
import ketthucmodule2.models.Product;
//import commons.FileUtils;
//import commons.Validates;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static String IMPORTED_PRODUCTS = "ImportedProducts";
    private static String EXPORT_PRODUCTS = "ExportProducts";
    public static int id = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenuProductManagement() {

        System.out.println("CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM");

        int choose;
        boolean isExit = false;
        do {
            System.out.println("CHỌN CHỨC NĂNG ĐỂ TIẾP TỤC " +
                    "\n1. Add New Product : Thêm mới" +
                    "\n2. Delete Product: Xóa sản phẩm" +
                    "\n3. Show List Product: Xem danh sách sản phẩm" +
                    "\n4. Lookup: Chỉnh sửa sản phẩm" +
                    "\n5. Exit");
            System.out.println("Chọn chức năng: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    showListProduct();
                    break;
                case 4:
                    lookUp();
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 5);
    }

    private static void addNewProduct() {
        int choose;
        boolean isExit = false;
        do {
            System.out.println("Select product to add new product" +
                    "\n1. Imported Products" +
                    "\n2. ExportProducts" +
                    "\n3. Back to main menu");
            System.out.println("Enter the type product: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    addNewProduct(IMPORTED_PRODUCTS);
                    break;
                case 2:
                    addNewProduct(EXPORT_PRODUCTS);
                    break;
                case 3:
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 3);
    }

    private static void addNewProduct(String nameProduct) {

        System.out.println("Nhập id code sản phẩm: ");
        String code;
        scanner.nextLine();
        do {
            code = scanner.nextLine();
        } while (!Validates.isCodeProduct(code));


        System.out.println("Nhập tên sản phẩm: ");
        String name;
        do {
            name = scanner.nextLine();
        } while (!Validates.isProduct(name));

        System.out.println("Nhập giá sản phẩm: ");
        String price;
        do {
            price = scanner.nextLine();
        } while (!Validates.isPositiveNumbers(price));

        System.out.println("Nhập số lượng sản phẩm :quantity ");
        String quantity;
        do {
            quantity = scanner.nextLine();
        } while (!Validates.isPositiveNumbers(quantity));


        System.out.println("Nhập nhà sản xuất: ");
        String manufacturer;
        do {
            manufacturer = scanner.nextLine();
        } while (!Validates.isProduct(manufacturer));

        if (nameProduct.equals(IMPORTED_PRODUCTS)) {

            System.out.println("Nhập giá nhập khẩu: ");
            String priceImportedProduct;
            do {
                priceImportedProduct = scanner.nextLine();
            } while (!Validates.isPositiveNumbers(priceImportedProduct));

            System.out.println("Nhập tỉnh thành nhập: ");
            String provinceImportedProduct;
            do {
                provinceImportedProduct = scanner.nextLine();
            } while (!Validates.isProduct(provinceImportedProduct));

            System.out.println("Nhập thuế nhập khẩu: ");
            String taxImportedProduct;
            do {
                taxImportedProduct = scanner.nextLine();
            } while (!Validates.isPositiveNumbers(taxImportedProduct));

            FileUtils.writeFile(new String[]{String.valueOf(id++), code, name, price, quantity,
                    manufacturer, priceImportedProduct, provinceImportedProduct, taxImportedProduct});

        } else if (nameProduct.equals(EXPORT_PRODUCTS)) {

            System.out.println("Nhập giá xuất khẩu: ");
            String priceExportProduct;
            do {
                priceExportProduct = scanner.nextLine();
            } while (!Validates.isPositiveNumbers(priceExportProduct));

            System.out.println("Nhập quốc gia xuất khẩu: ");
            String countryExportProduct;
            do {
                countryExportProduct = scanner.nextLine();
            } while (!Validates.isProduct(countryExportProduct));

            FileUtils.writeFile(new String[]{String.valueOf(id++), code, name, price, quantity,
                    manufacturer, priceExportProduct, countryExportProduct});
        }
    }

    private static void deleteProduct() {
        int choose;

        List<Product> productList = FileUtils.readProduct();

        System.out.println("Enter the code product need to delete");
        scanner.nextLine();
        String codeProduct;

        do {
            codeProduct = scanner.nextLine();
        } while (!Validates.isCodeProduct(codeProduct));
//        ném NotFoundProductException mới ("Mã sản phẩm không cần thiết, nhập lại");

        for (Product product : productList) {
            if (codeProduct.equals(product.getCodeProduct())) {
                System.out.println("Chọn chức năng 'Yes' or 'No'" +
                        "\n1. Yes - xóa sản phẩm" +
                        "\n2. No - trở về menu");
                choose = scanner.nextInt();
                switch (choose) {
                    case 1:
                        productList.remove(product);
                        FileUtils.writeAllProduct(productList);
                        List<Product> productListRemove = FileUtils.readProduct();
                        int i = 1;
                        for (Product productRemove : productListRemove) {
                            System.out.println("Sản phẩm sau khi xóa " + i + ": " + productRemove.toString());
                            i++;
                        }
                    case 2:
                        displayMenuProductManagement();
                        break;
                }
            }
        }
    }

    private static void showListProduct() {
        int choose;
        boolean isExit = false;
        do {
            System.out.println("Chọn sản phẩm cần xem" +
                    "\n1. Imported Products" +
                    "\n2. ExportProducts" +
                    "\n3. Back to main menu");
            System.out.println("Nhập loại sản phẩm: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    showListImportedProductsProduct();
                    break;
                case 2:
                    showListExportProductsProduct();
                    break;
                case 3:
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 3);
    }

    private static void showListImportedProductsProduct() {
        List<Product> productList = FileUtils.readProduct();
        int i = 1;
        for (Product product : productList) {
            if (product instanceof ImportedProducts) {
                System.out.println("Danh sách sản phẩm đã nhập " + i + ": " + product.toString());
                i++;
            }
        }
    }

    private static void showListExportProductsProduct() {
        List<Product> productList = FileUtils.readProduct();
        int i = 1;
        for (Product product : productList) {
            if (product instanceof ExportProducts) {
                System.out.println("Danh sách sản phẩm đã xuất " + i + ": " + product.toString());
            }
        }
    }

    private static void lookUp() {
        int choose;
        boolean isExit = false;
        do {
            System.out.println("Chọn chức năng cần sửa" +
                    "\n1. Sửa id Code " +
                    "\n2. Sửa tên" +
                    "\n3. Quay về  menu");
            System.out.println("Nhập lựa chọn: ");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    byCodeProduct();
                    break;
                case 2:
                    byNameProduct();
                    break;
                case 3:
                    isExit = true;
                    break;
            }
            if (isExit) {
                break;
            }
        } while (choose >= 1 && choose <= 3);
    }

    private static void byCodeProduct() {
        List<Product> productList = FileUtils.readProduct();
        System.out.println("Nhập mã sản phẩm để tìm");
        scanner.nextLine();
        String code = scanner.nextLine();

        for (Product product : productList) {
            if (code.equals(product.getCodeProduct())) {
                System.out.println("Sản phẩm cần tìm: " + product.toString());
            }
        }
    }

    private static void byNameProduct() {
        List<Product> productList = FileUtils.readProduct();
        System.out.println("Nhập tên sản phẩm để tìm");
        scanner.nextLine();
        String name = scanner.nextLine();

        for (Product product : productList) {
            if (name.equals(product.getNameProduct())) {
                System.out.println("Sản phẩm cần tìm: " + product.toString());
            }
        }
    }
}
