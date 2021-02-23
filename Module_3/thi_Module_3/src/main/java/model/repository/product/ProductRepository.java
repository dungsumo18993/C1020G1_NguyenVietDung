package model.repository.product;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {

    public List<Product> findAllProduct();

    public Product findProductById (int id);

    public void addProduct(Product product);
}
