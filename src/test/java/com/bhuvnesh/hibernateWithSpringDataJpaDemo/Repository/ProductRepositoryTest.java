package com.bhuvnesh.hibernateWithSpringDataJpaDemo.Repository;

import com.bhuvnesh.hibernateWithSpringDataJpaDemo.Entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest
{
    @Autowired
    ProductRepository productRepository;

    @Test
    public void saveMethod()
    {
        Product product = new Product();
        product.setName("product 1");
        product.setDescription("product 1 description");
        product.setSku("100ABC");
        product.setPrice(new BigDecimal(100));
        product.setActive(true);
        product.setImageUrl("product1.png");

        Product savedObject = productRepository.save(product);
    }

    @Test
    public void updateUsingSaveMethod()
    {
        Long id = 1L;
        Product product = productRepository.findById(id).get();

        product.setName("updated product 1");
        product.setDescription("updated product 1 description");

        productRepository.save(product);
    }

    @Test
    public void saveAllMethod()
    {
        Product product2 = new Product();
        product2.setName("product 2");
        product2.setDescription("product 2 description");
        product2.setSku("100DEF");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        Product product3 = new Product();
        product3.setName("product 3");
        product3.setDescription("product 3 description");
        product3.setSku("100GHI");
        product3.setPrice(new BigDecimal(300));
        product3.setActive(true);
        product3.setImageUrl("product3.png");

        productRepository.saveAll(List.of(product2, product3));
    }

    @Test
    public void finAllMethod()
    {
        List<Product> products = productRepository.findAll();

        products.forEach((p) -> {
            System.out.println(p.getName());
        });
    }

    @Test
    public void deleteByIdMethod()
    {
        Long id = 1L;
        productRepository.deleteById(id);
    }

    @Test
    public void deleteMethod()
    {
        Long id = 2L;
        Product product = productRepository.findById(id).get();

        productRepository.delete(product);
    }

    @Test
    public void deleteAllMethod()
    {
        //productRepository.deleteAll();

        Long id2 = 5L;
        Product product2 = productRepository.findById(id2).get();

        Long id3 = 6L;
        Product product3 = productRepository.findById(id3).get();

        productRepository.deleteAll(List.of(product2, product3));
    }

    @Test
    public void countMethod()
    {
        long count = productRepository.count();
        System.out.println(count);
    }

    @Test
    public void existsByIdMethod()
    {
        Long id = 7L;
        Boolean result = productRepository.existsById(id);
        System.out.println(result);
    }

}