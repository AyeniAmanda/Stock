package com.example.store.service;

import com.example.store.dto.StockDto;
import com.example.store.entity.Stock;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<StockDto> save(StockDto stockDto);

    Mono<StockDto> updateStockPrice(long id, StockDto stockDto);

    Flux<Stock> getAllStocks();

    Mono<StockDto> getStockById(long id);
}
