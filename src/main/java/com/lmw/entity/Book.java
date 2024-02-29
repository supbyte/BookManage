package com.lmw.entity;

import lombok.Data;

@Data
public class Book {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private String tittle;

    /**
     *
     */
    private String desc;

    /**
     *
     */
    private Long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}