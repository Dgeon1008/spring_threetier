package com.app.threetier.repository;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductDAO {

    private final ProductMapper productMapper;

//    상품 추가
    public void add(ProductVO productVO) {
        productMapper.insert(productVO);
    }
}
