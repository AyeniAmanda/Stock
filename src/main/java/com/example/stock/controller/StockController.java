package com.example.stock.controller;


import com.example.stock.dto.StockDto;
import com.example.stock.entity.Stock;
import com.example.stock.service.StockService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public Mono<StockDto> saveStock(@RequestBody StockDto stockDto) {
        return stockService.save(stockDto);
    }

    @PutMapping("/{id}")
    public Mono<StockDto> updateStockPrice(@PathVariable long id, @RequestBody StockDto stockDto) {
        return stockService.updateStockPrice(id, stockDto);
    }

    @GetMapping("/{id}")
    public Mono<StockDto> getStockById(@PathVariable long id) {
        return stockService.getStockById(id);
    }

    @GetMapping
    public Flux<StockDto> getAllStocks() {
        return stockService.getAllStocks();
    }

}
