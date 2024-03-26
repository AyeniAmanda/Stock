package com.example.stock.controller;


import com.example.stock.dto.StockDto;
import com.example.stock.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping
    public Mono<ResponseEntity<StockDto>> saveStock(@RequestBody StockDto stockDto) {
        return stockService.save(stockDto)
                .map(savedStockDto -> ResponseEntity.status(HttpStatus.CREATED).body(savedStockDto));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<StockDto>> updateStockPrice(@PathVariable long id, @RequestBody StockDto stockDto) {
        return stockService.updateStockPrice(id, stockDto)
                .map(updatedStockDto -> ResponseEntity.ok().body(updatedStockDto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<StockDto>> getStockById(@PathVariable long id) {
        return stockService.getStockById(id)
                .map(stockDto -> ResponseEntity.ok().body(stockDto))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<StockDto> getAllStocks() {
        return stockService.getAllStocks();
    }
}
