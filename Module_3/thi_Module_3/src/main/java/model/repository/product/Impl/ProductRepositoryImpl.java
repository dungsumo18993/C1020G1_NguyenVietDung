package model.repository.product.Impl;

import model.bean.Product;
import model.repository.product.ProductRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    BaseRepository baseRepository = new BaseRepository();

    private static final String SELECT_ALL_PRODUCT = "select san_pham_id, ten_san_pham, gia_san_pham, muc_giam_gia, ton_kho" +
            " from san_pham";

    private static final String INSERT_PRODUCT = "insert into san_pham" +
            " (ten_san_pham, gia_san_pham, muc_giam_gia, ton_kho)" +
            " values (?, ?, ?, ?)";
    @Override
    public List<Product> findAllProduct() {
        List<Product> productList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(SELECT_ALL_PRODUCT);

            ResultSet rs = preparedStatement.executeQuery();

            Product product = null;
            while (rs.next()){
                product = new Product();
                product.setId(Integer.parseInt(rs.getString("san_pham_id")));
                product.setName(rs.getString("ten_san_pham"));
                product.setPrice(Double.parseDouble(rs.getString("gia_san_pham")));
                product.setDiscount(Integer.parseInt(rs.getString("muc_giam_gia")));
                product.setStock(Integer.parseInt(rs.getString("ton_kho")));

                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) {
        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getDiscount());
            preparedStatement.setInt(3, product.getDiscount());
            preparedStatement.setInt(4, product.getStock());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
