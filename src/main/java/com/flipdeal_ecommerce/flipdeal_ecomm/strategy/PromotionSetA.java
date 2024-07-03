package com.flipdeal_ecommerce.flipdeal_ecomm.strategy;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Discount;
import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import org.springframework.stereotype.Component;

@Component("PROMOTIONSETA")
public class PromotionSetA implements PromotionStrategy{
    @Override
    public Discount applyDiscount(Product product) {
        Discount discountDetails=new Discount();
        double max_discount=0.00;
        if(product.getOrigin().equals("Africa")){

            double discount= product.getPrice()*0.07;
            if(max_discount<discount){
                max_discount=discount;
                discountDetails.setDiscountTag("7% discount applied");
            }
        }
        if(product.getRating()==2.00){

            double discount= product.getPrice()*0.04;
            if(max_discount<discount){
                max_discount=discount;
                discountDetails.setDiscountTag("4% discount applied");
            }
        }
        else if(product.getRating()<2.00){

            double discount= product.getPrice()*0.08;
            if(max_discount<discount){
                max_discount=discount;
                discountDetails.setDiscountTag("8% discount applied");
            }
        }
        if(product.getCategory().equals("electronics")
                ||product.getCategory().equals("furnishing")){
            if(product.getPrice()>500){

                if(max_discount<100.00){
                    max_discount=100.00;
                    discountDetails.setDiscountTag("100 rs off");
                }
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
