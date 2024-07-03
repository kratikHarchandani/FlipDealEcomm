package com.flipdeal_ecommerce.flipdeal_ecomm.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipdeal_ecommerce.flipdeal_ecomm.Client.FlipDealClient;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Discount;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import com.flipdeal_ecommerce.flipdeal_ecomm.strategy.PromotionStrategy;
import com.flipdeal_ecommerce.flipdeal_ecomm.utils.Commons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    private FlipDealClient flipDealClient;
    private Map<String, PromotionStrategy> promotionStrategies;

    @Autowired
    ProductService(FlipDealClient flipDealClient,
                   Map<String,PromotionStrategy> promotionStrategies){
        this.flipDealClient = flipDealClient;
        this.promotionStrategies = promotionStrategies;
    }

    public List<Product> applyPromotion(String promotionType) throws IOException {
        List<Product> productDetails = flipDealClient.fetchProductDetails();
        Map<String,Object> map = flipDealClient.fetchCurrencyChange();
        List<Product> updatedProductDetails = Commons.convertCurrencyToINR(productDetails,map);
        for(Product updatedProduct:updatedProductDetails) {
            Discount discountDetails=getPromotionStrategy(promotionType).applyDiscount(updatedProduct);
            updatedProduct.setDiscount(discountDetails);
        }
        return updatedProductDetails;
    }

    private PromotionStrategy getPromotionStrategy(String promotionType){
        if(!promotionStrategies.containsKey(promotionType)){
            throw new RuntimeException("Invalid PromotionType");
        }
        return promotionStrategies.get(promotionType);
    }


}
