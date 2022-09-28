package com.rrssys.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "book_on_tape")
public class BookOnTape extends Thing{
    @Column
    private Integer chapter;
    @Column
    private String author;
    @Override
    public String getDescription() {
        return "This is books on tape";
    }
}
