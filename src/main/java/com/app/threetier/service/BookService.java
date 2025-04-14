package com.app.threetier.service;

import com.app.threetier.domain.BookVO;
import com.app.threetier.repository.BookDAO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BookService {

  public void register(BookVO bookVO);

  public List<BookVO> getList();

  public Optional<BookVO> getById(Long id);

  public void edit(BookVO bookVO);

  public void remove(Long id);

}
