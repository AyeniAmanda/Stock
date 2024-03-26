package com.example.store.repo;

import com.example.store.entity.Stock;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface StockRepository extends ReactiveCrudRepository<Stock, Long> {
}
