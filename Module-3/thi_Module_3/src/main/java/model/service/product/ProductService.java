package model.service.product;

import model.bean.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllProduct();

    public Product findProductById (int id);

    public void addProduct(Product product);

}
