package com.example.stock;


import com.example.stock.dto.StockDto;
import com.example.stock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Config implements CommandLineRunner {
    private final StockService stockService;

    @Override
    public void run(String... args) throws Exception {
        stockService.save(new StockDto(3000.00, "Stock rice")).subscribe();
        stockService.save(new StockDto(500.00, "Efemena")).subscribe();
        System.out.println();
    }

}
