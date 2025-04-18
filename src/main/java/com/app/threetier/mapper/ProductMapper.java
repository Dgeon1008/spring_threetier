package com.app.threetier.mapper;

import com.app.threetier.domain.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductMapper {

//    상품 추가
    public void insert(ProductVO productVO);

//    상품 리스트
    public List<ProductVO> selectAll();

//    상품 단일 조회
    public Optional<ProductVO> select(Long id);

//    상품 수정
    public void update(ProductVO productVO);

//    상품 삭제
    public void delete(Long id);

}






