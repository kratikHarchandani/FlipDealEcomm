package com.flipdeal_ecommerce.flipdeal_ecomm;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal_ecommerce.flipdeal_ecomm.Client.FlipDealClient;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.CurrencyChange;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonBuilderCustomizer;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class FlipDealEcommApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FlipDealEcommApplication.class, args);
//        String obj = FlipDealClient.getAllProducts();
//        //For conversion of Person object(person) to json String:
//        String obj2=FlipDealClient.getCurrencyChange();
//        //String personJsonString = new ObjectMapper().writeValueAsString(obj);
//        ObjectMapper mapper=new ObjectMapper();
//
//        //For conversion of json String back to Person object(person)
//
//        List<Product> productList = mapper.readValue(obj,
//                mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
//        CurrencyChange currencyChange=mapper.readValue(obj2,CurrencyChange.class);
//        currencyChange.getRates();
    }

}
