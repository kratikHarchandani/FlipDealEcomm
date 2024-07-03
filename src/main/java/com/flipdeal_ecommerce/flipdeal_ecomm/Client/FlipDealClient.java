package com.flipdeal_ecommerce.flipdeal_ecomm.Client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import com.flipdeal_ecommerce.flipdeal_ecomm.utils.HttpCaller;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FlipDealClient {

    public List<Product> fetchProductDetails() throws IOException {
        Map <String,String> headers=new HashMap<>();
        String obj= HttpCaller.get("https://mock.coverself.net/rest/hiring/products",
                headers);
        ObjectMapper mapper=new ObjectMapper();
        List<Product> productList = mapper.readValue(obj,
                mapper.getTypeFactory().constructCollectionType(List.class, Product.class));
        return productList;
    }

//    public static String getCurrencyChange() throws IOException {
//        return HttpCaller.get("https://mock.coverself.net/rest/hiring/exchange-rates",null);
//    }
    public  Map<String, Object> fetchCurrencyChange() throws IOException {

        String response = HttpCaller.get("https://mock.coverself.net/rest/hiring/exchange-rates", null);
        ObjectMapper mapper = new ObjectMapper();
        return (Map<String, Object>) new ObjectMapper().readValue(response, HashMap.class).get("rates");

    }
}

