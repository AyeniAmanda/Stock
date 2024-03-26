package com.example.stock;

import com.example.stock.dto.StockDto;
import com.example.stock.entity.Stock;
import com.example.stock.repo.StockRepository;
import com.example.stock.service.serviceImpl.StockServiceImplementation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
class StockApplicationTests {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImplementation stockService;

    @Test
    @DisplayName("When a new product is added the stock gets saved")
    public void testSave() {
        StockDto stockDto = new StockDto();
        stockDto.setName("Test Stock");
        stockDto.setAmount(100.0);

        Mockito.when(stockRepository.save(any(Stock.class))).thenReturn(Mono.just(new Stock()));

        Mono<StockDto> result = stockService.save(stockDto);

        StepVerifier.create(result)
                .expectNextCount(1);


        verify(stockRepository).save(any(Stock.class));
    }


    @Test
    @DisplayName("when an changes are made to an existing stock update")
    public void testUpdateStockPrice() {
        long id = 1L;
        StockDto stockDto = new StockDto();
        stockDto.setName("Updated Stock");
        stockDto.setAmount(150.0);

        Stock existingStock = new Stock();
        existingStock.setId(id);
        existingStock.setName("Test Stock");
        existingStock.setCurrentPrice(BigDecimal.valueOf(100.0));

        Mockito.when(stockRepository.findById(id)).thenReturn(Mono.just(existingStock));
        Mockito.when(stockRepository.save(existingStock)).thenReturn(Mono.just(existingStock));

        Mono<StockDto> result = stockService.updateStockPrice(id, stockDto);

        StepVerifier.create(result)
                .expectNextMatches(updatedStockDto -> updatedStockDto.getName().equals("Updated Stock")
                        && updatedStockDto.getAmount() == 150.0)
                .verifyComplete();

        verify(stockRepository).findById(id);
        verify(stockRepository).save(existingStock);
    }

    @Test
    @DisplayName("Retrieve stock  by Id")
    public void testGetStockById() {
        long id = 1L;
        Stock existingStock = new Stock();
        existingStock.setId(id);
        existingStock.setName("Test Stock");
        existingStock.setCurrentPrice(BigDecimal.valueOf(100.0));

        Mockito.when(stockRepository.findById(id)).thenReturn(Mono.just(existingStock));

        Mono<StockDto> result = stockService.getStockById(id);

        StepVerifier.create(result)
                .expectNextMatches(stockDto -> stockDto.getName().equals("Test Stock")
                        && stockDto.getAmount() == 100.0)
                .verifyComplete();

        verify(stockRepository).findById(id);
    }
}
