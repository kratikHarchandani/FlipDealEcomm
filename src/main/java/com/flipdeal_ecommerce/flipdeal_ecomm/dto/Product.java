package com.flipdeal_ecommerce.flipdeal_ecomm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
 private String category;
 private int inventory;
 private String arrival;
 private double rating;
 private String currency;
 private double price;
 private String origin;
 private String product;
 private Discount discount;
}
