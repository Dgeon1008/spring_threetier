package com.app.threetier.service;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.repository.ProductDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

//    상품 추가
    @Override
    public void productAdd(ProductVO productVO) {
        productDAO.save(productVO);
    }

//    상품 리스트
    @Override
    public List<ProductVO> getList() {
        return productDAO.selectAll();
    }

//    단일 조회
    @Override
    public Optional<ProductVO> getProductById(Long id) {
        return productDAO.findById(id);
    }

//    수정
    @Override
    public void edit(ProductVO productVO) {
        productDAO.editById(productVO);
    }

//    삭제
    @Override
    public void removeProduct(Long id) {
        productDAO.deleteById(id);
    }


    
}
