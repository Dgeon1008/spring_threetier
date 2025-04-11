package com.app.threetier.controller;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.service.PostService;
import com.app.threetier.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/product/*")
@RequiredArgsConstructor
public class TaskController {

    private final ProductService productService;

    @GetMapping("add")
    public void goToAdd(Model model) {
        model.addAttribute("productVO", new ProductVO());
    }

    @PostMapping("add")
    public RedirectView add(ProductVO productVO) {
        productService.add(productVO);
        return new RedirectView("product/list");

    }

}
