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




    @GetMapping
    public Flux<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Mono<StockDto> getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PutMapping("/{id}")
    public Mono<StockDto> updateStockPrice(@PathVariable Long id, @RequestParam BigDecimal newPrice) {
        return stockService.updateStockPrice(id, newPrice);
    }

    @PostMapping
    public Mono<Stock> createStock(@RequestBody StockDto stockDto) {
        return stockService.save(stockDto);
    }
}


