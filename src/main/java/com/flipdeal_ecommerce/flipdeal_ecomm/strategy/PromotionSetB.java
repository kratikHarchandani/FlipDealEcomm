package com.flipdeal_ecommerce.flipdeal_ecomm.strategy;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Discount;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import org.springframework.stereotype.Component;

@Component("PROMOTIONSETB")
public class PromotionSetB implements PromotionStrategy{
    @Override
    public Discount applyDiscount(Product product) {
        Discount discountDetails =new Discount();
        double max_discount=0.00;
        if(product.getInventory()>20){
            double price= product.getPrice()*0.12;
            if(max_discount<price){
                max_discount=price;
                discountDetails.setDiscountTag("12% discount applied");
            }
        }
        if(product.getArrival().equals("new")){
            double price=product.getPrice()*0.07;
            if(max_discount<price){
                max_discount=price;
                discountDetails.setDiscountTag("7% discount applied");
            }
        }
        discountDetails.setAmount(max_discount);
        if(discountDetails==null&&product.getPrice()>1000.00){
            discountDetails.setDiscountTag("2% discount applied");
            double price= product.getPrice()*0.02;
            discountDetails.setAmount(price);
        }
        return discountDetails;
    }
}
