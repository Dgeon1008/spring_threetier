package com.app.threetier.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ProductVO {
    private Long id;
    private String productName;
//    검증할 때 NULL로 비교하기 위해서 int -> Integer
    private int productPrice;
    private int productStock;
    private String productBrand;
}
