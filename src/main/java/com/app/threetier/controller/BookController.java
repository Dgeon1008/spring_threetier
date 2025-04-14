package com.app.threetier.controller;

import com.app.threetier.domain.BookVO;
import com.app.threetier.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/book/*")
@Slf4j
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("write")
    public void goToWrite(Model model) {
        model.addAttribute("BookVO", new BookVO());
    }

    @PostMapping("write")
    public RedirectView write(BookVO bookVO) {
        bookService.register(bookVO);
        return new RedirectView("/book/list");
    }

    @GetMapping("list")
    public void list(Model model) {
        model.addAttribute("books", bookService.getList());
    }

    @GetMapping("read")
    public void read(@RequestParam("id") Long id, Model model) {
        model.addAttribute("books", bookService.getById(id).orElseThrow(() -> {
            throw new RuntimeException("Book Not Found");
        }));
    }

    @GetMapping("edit")
    public void edit(@RequestParam("id") Long id, Model model) {
        BookVO bookVO = bookService.getById(id).orElseThrow(() -> {
            throw new RuntimeException("Book Not Found");
        });
        model.addAttribute("BookVO", bookVO);
    }

    @PostMapping("edit")
    public RedirectView edit(BookVO bookVO) {
        bookService.edit(bookVO);
        return new RedirectView("/book/list");
    }

    @GetMapping("remove")
    public RedirectView remove(@RequestParam("id") Long id) {
        bookService.remove(id);
        return new RedirectView("/book/list");
    }


}
