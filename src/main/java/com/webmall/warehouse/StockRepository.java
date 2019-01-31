package com.webmall.warehouse;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stocks", path = "stocks")
interface StockRepository extends JpaRepository<Stock, Long>{
	
    List<Stock> findStockByProductId(Long productId);
    
}