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
import org.springframework.web.bind.annotation.RequestParam;
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
        productService.productAdd(productVO);
        return new RedirectView("/product/list");

    }

    @GetMapping("list")
    public void goToList(Model model) {
        model.addAttribute("products",productService.getList());
    }

    @GetMapping("read")
    public void goToRead(@RequestParam("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id).orElseThrow(() -> {
            throw new RuntimeException("product not found");
        }));
    }

    @GetMapping("edit")
    public void edit(@RequestParam("id") Long id, Model model) {
        ProductVO productVO = productService.getProductById(id).orElseThrow(() -> {
            throw new RuntimeException("product not found");
        });
        model.addAttribute("productVO", productVO);
    }

    @PostMapping("edit")
    public RedirectView edit(ProductVO productVO) {
        productService.edit(productVO);
        return new RedirectView("/product/list");
    }

    @GetMapping("remove")
    public RedirectView removeProduct(@RequestParam("id") Long id) {
        productService.removeProduct(id);
        return new RedirectView("/product/list");
    }

}










