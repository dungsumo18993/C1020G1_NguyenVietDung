package com.example.repository.Impl;

import com.example.model.Product;
import com.example.repository.ProductsRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductRepoImpl implements ProductsRepo {
    private static Map<Integer,Product> products = new HashMap<>();
    static {
        products.put(1, new Product(1,"Z1000",500,"Kawasaki"));
        products.put(2, new Product(2,"R1M",900,"Yamaha"));
        products.put(3, new Product(3,"CBR1000",600,"Honda"));
        products.put(4, new Product(4,"S1000RR",1100,"BMW"));
        products.put(5, new Product(5,"H2R",1400,"Kawasaki"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
