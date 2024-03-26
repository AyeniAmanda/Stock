package com.example.stock.service;

import com.example.stock.dto.StockDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StockService {
    Mono<StockDto> save(StockDto stockDto);

    Mono<StockDto> updateStockPrice(long id, StockDto stockDto);

    Flux<StockDto> getAllStocks();

    Mono<StockDto> getStockById(long id);
}
