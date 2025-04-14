package com.app.threetier.repository;

import com.app.threetier.domain.BookVO;
import com.app.threetier.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookDAO {

    private final BookMapper bookMapper;

    public void save(BookVO bookVO) {
        bookMapper.insert(bookVO);
    }

    public List<BookVO> findAll() {
        return bookMapper.selectAll();
    }

    public Optional<BookVO> findById(Long id) {
        return bookMapper.select(id);
    }

    public void updateById(BookVO bookVO) {
        bookMapper.update(bookVO);
    }

    public void deleteById(Long id) {
        bookMapper.delete(id);
    }


}
