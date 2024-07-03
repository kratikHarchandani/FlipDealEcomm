package com.flipdeal_ecommerce.flipdeal_ecomm.strategy;


import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Discount;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;


public interface PromotionStrategy {
    public Discount applyDiscount(Product product);

}
