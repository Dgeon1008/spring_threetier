package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import com.app.threetier.domain.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class ProductMapperTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void insertTest() {
        ProductVO productVO = new ProductVO();
        productVO.setProductName("testProduct1");
        productVO.setProductPrice(200000);
        productVO.setProductStock(20);
        productVO.setProductBrand("testBrand1");

        productMapper.insert(productVO);
    }

    @Test
    public void selectAllTest() {
        List<ProductVO> products = productMapper.selectAll();
        products.stream().map(ProductVO::toString).forEach(log::info);

    }


}
