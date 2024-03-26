package com.example.stock.service.serviceImpl;

import com.example.stock.entity.Stock;
import com.example.stock.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StockInitializationService implements ApplicationRunner {

    private final StockRepository stockRepository;

    @Autowired
    public StockInitializationService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Stock> initialStocks = new ArrayList<>();
        initialStocks.add(new Stock(1L, "Bags", BigDecimal.valueOf(100), LocalDateTime.now(), LocalDateTime.now()));
        initialStocks.add(new Stock(2L, "Cars", BigDecimal.valueOf(200), LocalDateTime.now(), LocalDateTime.now()));
        initialStocks.add(new Stock(3L, "Chairs", BigDecimal.valueOf(300), LocalDateTime.now(), LocalDateTime.now()));
        initialStocks.add(new Stock(4L, "Fans", BigDecimal.valueOf(400), LocalDateTime.now(), LocalDateTime.now()));

        stockRepository.saveAll(initialStocks).subscribe();
    }
}
