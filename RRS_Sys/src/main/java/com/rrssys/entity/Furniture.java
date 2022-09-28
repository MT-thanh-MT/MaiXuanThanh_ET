package com.rrssys.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "furniture")
public class Furniture extends Thing{
    @Column
    private String material;
    @Column
    private Double weigh;
    @Override
    public String getDescription() {
        return "This is furniture";
    }
}
