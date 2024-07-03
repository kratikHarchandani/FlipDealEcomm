package com.flipdeal_ecommerce.flipdeal_ecomm.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class CurrencyChange {
    private String base;
    private Date date;
    private Map<String,Double> rates;
    private boolean success;
    private Date timestamp;
}
