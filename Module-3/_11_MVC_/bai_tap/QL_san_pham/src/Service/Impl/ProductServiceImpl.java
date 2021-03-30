package Service.Impl;

import Model.Product;
import Service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> products;

    static {
        products = new TreeMap<>();
        products.put(1,new Product(1,"H2R",1200,"New","Kawasaki"));
        products.put(2,new Product(2,"R1M",1000,"New","Yamaha"));
        products.put(3,new Product(3,"CBR1000",1100,"New","Honda"));
        products.put(4,new Product(4,"BMW",1400,"New","BMW"));
        products.put(5,new Product(5,"Z-1000",900,"New","Kawasaki"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        return products.get(name);
    }
}
