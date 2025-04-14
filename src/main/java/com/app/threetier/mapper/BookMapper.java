package com.app.threetier.mapper;

import com.app.threetier.domain.BookVO;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Mapper
public interface BookMapper {

    public void insert(BookVO bookVO);

    public List<BookVO> selectAll();

    public Optional<BookVO> select(Long id);

    public void update(BookVO bookVO);

    public void delete(Long id);

}
