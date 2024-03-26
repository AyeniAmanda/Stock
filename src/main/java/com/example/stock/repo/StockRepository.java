package com.example.stock.repo;

import com.example.stock.entity.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
}
