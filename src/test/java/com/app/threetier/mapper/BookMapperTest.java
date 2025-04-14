package com.app.threetier.mapper;

import com.app.threetier.domain.BookVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class BookMapperTest {

    @Autowired
    BookMapper bookMapper;

    @Test
    public void insertTest() {
        BookVO bookVO = new BookVO();
        bookVO.setBookTitle("title1");
        bookVO.setBookAuthor("author1");
        bookVO.setBookPrice(10000);
        bookVO.setBookStock(5);

        bookMapper.insert(bookVO);
    }

    @Test
    public void selectAllTest() {
        List<BookVO> books = bookMapper.selectAll();
        books.stream().map(book -> toString()).forEach(log::info);
    }

    @Test
    public void selectTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(2L);
        bookMapper.select(bookVO.getId()).map(BookVO::toString).ifPresent(log::info);
    }

    @Test
    public void updateTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(1L);
        bookVO.setBookTitle("title2");
        bookVO.setBookAuthor("author2");
        bookVO.setBookPrice(10000);
        bookVO.setBookStock(5);

        bookMapper.update(bookVO);
    }

    @Test
    public void deleteTest() {
        BookVO bookVO = new BookVO();
        bookVO.setId(1L);

        bookMapper.delete(bookVO.getId());
    }





}











