package com.example.repository.Impl;

import com.example.model.Product;
import com.example.repository.ProductsRepo;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


@Service
@Repository
public class ProductRepoImpl implements ProductsRepo {

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery =
                BaseRepository.entityManager.createQuery("select p from Product p", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        if(product.getId() == null){
            BaseRepository.entityManager.persist(product);
        }else {
            BaseRepository.entityManager.merge(product);
        }
        entityTransaction.commit();
    }

    @Override
    public Product findById(Integer id) {
        return BaseRepository.entityManager.find(Product.class, id);
    }

    @Override
    public void remove(Integer id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        Product product = BaseRepository.entityManager.find(Product.class,id);
        entityTransaction.begin();
        BaseRepository.entityManager.remove(product);
        entityTransaction.commit();
    }
}
