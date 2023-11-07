package com.bhuvnesh.hibernateWithSpringDataJpaDemo.Repository;

import com.bhuvnesh.hibernateWithSpringDataJpaDemo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long>
{

}
