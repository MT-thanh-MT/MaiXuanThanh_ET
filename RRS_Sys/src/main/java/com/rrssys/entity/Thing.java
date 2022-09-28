package com.rrssys.entity;

import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@MappedSuperclass
public abstract class Thing {
    abstract public String getDescription();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private Long seri;
    @Column
    private String name;
    @Column
    private BigDecimal rentalPrice;
    @Column
    private Integer quantity;
    public void setSeri(Long seri) {
        this.seri = seri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRentalPrice(BigDecimal rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
