package com.flipdeal_ecommerce.flipdeal_ecomm.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class JwtResponse {
    private String token;
    private String userName;

}
