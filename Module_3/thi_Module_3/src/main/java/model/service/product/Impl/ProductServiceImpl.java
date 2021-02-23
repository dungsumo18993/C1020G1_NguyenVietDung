package model.service.product.Impl;

import model.bean.Product;
import model.repository.product.Impl.ProductRepositoryImpl;
import model.repository.product.ProductRepository;
import model.service.product.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository = new ProductRepositoryImpl();
    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);

    }
}
