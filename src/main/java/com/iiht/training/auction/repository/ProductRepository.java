package com.iiht.training.auction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iiht.training.auction.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByCategory(String category);

}
