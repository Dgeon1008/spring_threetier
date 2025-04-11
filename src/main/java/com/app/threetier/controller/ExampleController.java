package com.app.threetier.controller;

import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

//    http://localhost:10000/ex/ex01
    @GetMapping("ex01")
    public void ex01() {
        log.info("ex01 여기 실행됌!");
    };

//    http://localhost:10000/ex/ex02?name="홍길동"
//    @GetMapping("ex02")
//    public void ex02(String name, Model model) {
//        log.info(name);
//        model.addAttribute("name", name);
//    }
    @GetMapping("ex02")
    public void ex02(@ModelAttribute("name") String name) {
        log.info(name);
    }

    @GetMapping("ex03")
    public void ex03(@ModelAttribute("name") String name, @ModelAttribute("age") int age) {
        log.info(name);
        log.info("{}", age);
    }

    @GetMapping("ex04")
    public void ex04(@RequestParam("name") String name, @RequestParam("job") String job, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("job", job);
        log.info(job);
        log.info(name);
    }

//    화면에서 userVO 받기
    @GetMapping("ex05")
    public void ex05(UserVO userVO) {
        log.info(userVO.toString());
    }

//    상품이름, 상품가격
//    ProductVO로 생성한 후
//    화면에서 ex06으로 상품명과 상품가격을 받아서 요청했을때
//    log로 productVO 출력하기!
    @GetMapping("ex06")
    public void ex06(@ModelAttribute ProductVO productVO) {
        log.info(productVO.toString());
    }


}












