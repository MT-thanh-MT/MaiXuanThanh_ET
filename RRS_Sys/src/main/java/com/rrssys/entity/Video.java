package com.rrssys.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "video")
public class Video extends Thing{
    @Column
    private Double capacity;
    @Column
    private String resolution;

    @Override
    public String getDescription() {
        return "This is video";
    }
}
