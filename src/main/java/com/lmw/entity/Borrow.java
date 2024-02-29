package com.lmw.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer sid;

    /**
     *
     */
    private Integer bid;

    /**
     *
     */
    private Date time;

    private String bookName;
    private String studentName;
}