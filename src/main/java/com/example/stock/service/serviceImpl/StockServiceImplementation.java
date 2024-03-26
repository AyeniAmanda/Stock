package com.example.stock.service.serviceImpl;


import com.example.stock.dto.StockDto;
import com.example.stock.entity.Stock;
import com.example.stock.exception.NotFoundAlertException;
import com.example.stock.repo.StockRepository;
import com.example.stock.service.StockService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class StockServiceImplementation implements StockService {

    private final StockRepository stockRepository;

    public StockServiceImplementation(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    @Override
    public Mono<StockDto> save(StockDto stockDto) {
        Stock stock = mapDtoToStock(stockDto);
        return stockRepository.save(stock)
                .map(this::mapToDto);
    }

    @Override
    public Mono<StockDto> updateStockPrice(long id, StockDto stockDto) {
        return stockRepository.findById(id)
                .flatMap(existingStock -> {
                    if (existingStock != null) {
                        updateStockDetails(existingStock, stockDto);
                        return stockRepository.save(existingStock)
                                .map(this::mapToDto);
                    } else {
                        return Mono.error(new NotFoundAlertException("Stock not found with ID: " + id));
                    }
                });
    }

    private void updateStockDetails(Stock existingStock, StockDto stockDto) {
        if (stockDto != null) {
            if (stockDto.getName() != null) {
                existingStock.setName(stockDto.getName());
            }
            if (stockDto.getAmount() != null) {
                existingStock.setCurrentPrice(BigDecimal.valueOf(stockDto.getAmount()));
            }
            existingStock.setLastUpdate(LocalDateTime.now());
        }
    }

    @Override
    public Flux<StockDto> getAllStocks() {
        return stockRepository.findAll()
                .map(this::mapToDto);
    }

    @Override
    public Mono<StockDto> getStockById(long id) {
        return stockRepository.findById(id)
                .flatMap(stock -> {
                    if (stock != null) {
                        return Mono.just(mapToDto(stock));
                    } else {
                        return Mono.error(new NotFoundAlertException("No stock found with ID: " + id));
                    }
                });
    }
    private StockDto mapToDto(Stock stock) {
        StockDto stockDto = new StockDto();
        stockDto.setName(stock.getName());
        stockDto.setAmount(stock.getCurrentPrice().doubleValue());
        return stockDto;
    }

    private Stock mapDtoToStock(StockDto stockDto) {
        Stock stock = new Stock();
        stock.setName(stockDto.getName());
        stock.setCurrentPrice(BigDecimal.valueOf(stockDto.getAmount()));
        stock.setCreateDate(LocalDateTime.now());
        stock.setLastUpdate(LocalDateTime.now());
        return stock;
    }


}


