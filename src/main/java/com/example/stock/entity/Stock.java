package com.example.stock.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "stock")
@SuppressWarnings("common-java:DuplicatedBlocks")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @org.springframework.data.annotation.Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;

    @Column("currentPrice")
    private BigDecimal currentPrice;

    @Column("created_date")
    private LocalDateTime createDate;
    @Column("updated_date")
    private LocalDateTime lastUpdate;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) && Objects.equals(name, stock.name) && Objects.equals(currentPrice, stock.currentPrice) && Objects.equals(createDate, stock.createDate) && Objects.equals(lastUpdate, stock.lastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, currentPrice, createDate, lastUpdate);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
