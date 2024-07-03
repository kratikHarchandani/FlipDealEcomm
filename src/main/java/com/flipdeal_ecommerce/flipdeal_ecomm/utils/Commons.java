package com.flipdeal_ecommerce.flipdeal_ecomm.utils;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Commons {
    public static List<Product> convertCurrencyToINR(List<Product> productDetails, Map<String,Object> map) throws IOException {


        for(Product product:productDetails){
            if(!product.getCurrency().equals("INR")){
                double price= product.getPrice();
                String currency= product.getCurrency();
                price=price*(double)map.get(currency);
                product.setCurrency("INR");
                product.setPrice(price);
            }
        }
        return productDetails;
    }
}
