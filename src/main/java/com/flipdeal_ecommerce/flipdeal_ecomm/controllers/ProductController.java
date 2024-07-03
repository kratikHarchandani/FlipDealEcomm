package com.flipdeal_ecommerce.flipdeal_ecomm.controllers;

import com.flipdeal_ecommerce.flipdeal_ecomm.dto.Product;
import com.flipdeal_ecommerce.flipdeal_ecomm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Api/v1/Product")
//@PreAuthorize("hasRole('USER')")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/discount/{promotionStrategy}")
    public List<Product> applyPromotion(@PathVariable String promotionStrategy) throws IOException {
        return this.productService.applyPromotion(promotionStrategy);
    }
}
