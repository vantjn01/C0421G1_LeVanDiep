package model.repository;

import model.bean.Product;
import model.repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepository implements IProductRepository {

    static Map<Integer, Product> productMap = new TreeMap<>();

    static {
        productMap.put(1, new Product(1, "Gạo",
                1000, "ST25", "Thái Lan"));
        productMap.put(2, new Product(2, "Xe",
                2000, "BMW", "Đức"));
        productMap.put(3, new Product(3, "Cà phê",
                3000, "Caitucai", "Brazil"));
        productMap.put(4, new Product(4, "Điện Thoại",
                4000, "IPhone", "Mỹ"));
        productMap.put(5, new Product(5, "Tên lửa",
                5000, "Kim Jong-Un", "Triều Tiên"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findByName(String name) {
        for (Map.Entry<Integer, Product> m: productMap.entrySet()) {
            if (name.equals(m.getValue().getName())) {
                return m.getValue();
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}