package com.app.threetier.controller;

import com.app.threetier.domain.CompanyVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.domain.TaskVO;
import com.app.threetier.service.CompanyService;
import com.app.threetier.service.PostService;
import com.app.threetier.service.ProductService;
import com.app.threetier.service.TaskService;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
//@RequestMapping("/task/*")
@RequiredArgsConstructor
public class TaskController {

//    private final ProductService productService;
    private final ProductService productService;
    private final TaskService taskService;
    private final CompanyService companyService;
//
//    @GetMapping("add")
//    public void goToAdd(ProductVO productVO){;}
//
//    @PostMapping("add")
//    public RedirectView add(ProductVO productVO) {
//        productService.productAdd(productVO);
//        return new RedirectView("/product/list");
//
//    }
//
//    @GetMapping("list")
//    public void goToList(Model model) {
//        model.addAttribute("products",productService.getList());
//    }
//
//    @GetMapping("read")
//    public void goToRead(@RequestParam("id") Long id, Model model) {
//        model.addAttribute("product", productService.getProductById(id).orElseThrow(() -> {
//            throw new RuntimeException("product not found");
//        }));
//    }
//
//    @GetMapping("edit")
//    public void edit(@RequestParam("id") Long id, Model model) {
//        ProductVO productVO = productService.getProductById(id).orElseThrow(() -> {
//            throw new RuntimeException("product not found");
//        });
//        model.addAttribute("productVO", productVO);
//    }
//
//    @PostMapping("edit")
//    public RedirectView edit(ProductVO productVO) {
//        productService.edit(productVO);
//        return new RedirectView("/product/list");
//    }
//
//    @GetMapping("remove")
//    public RedirectView removeProduct(@RequestParam("id") Long id) {
//        productService.removeProduct(id);
//        return new RedirectView("/product/list");
//    }

    @GetMapping("register")
    public void goToRegister(TaskVO taskVO) {;}

    @PostMapping("register")
    public RedirectView register(TaskVO taskVO) {
        taskService.register(taskVO);
        return new RedirectView("/result");
    }

    @GetMapping("result")
    public void goToResultForm(Model model) {
//        model.addAttribute("tasks", taskService.getTasks());
    }

//    3번 실습
    @GetMapping("/company/check-in")
    public void goToCheckInForm(CompanyVO companyVO) {;}

//    출근
    @GetMapping("/company/get-to-work")
    public void goToGetToWork() {;}

//    퇴근
    @GetMapping("/company/leave-work")
    public void goToLeaveWork() {;}

//    지각
    @GetMapping("/company/late")
    public void goToLate() {;}

//    일하는 중
    @GetMapping("/company/work")
    public void goToWork() {;}

    @PostMapping("/company/check-in")
    public RedirectView checkIn(CompanyVO companyVO, String flag) {
        LocalDateTime now = LocalDateTime.now();

//        자바
        String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("{}", format);

        int hours = now.getHour();
        int minutes = now.getMinute();

//        지각
        boolean lateCondition = hours >=9 && minutes > 0;
//        퇴근
        boolean leaveWorkCondition = hours >= 17 && minutes >= 0;

        if(flag.equals("getToWork")) {
            companyVO.setGetToWorkDateTime(format);
            companyService.register(companyVO);
//            횡단로직
            log.info("{}", companyVO);

//            출근 시간 초가? 지각 : 정시출근
            return new RedirectView(lateCondition ? "/company/late" : "/company/get-to-work");
        }
//        퇴근
        companyVO.setLeaveWorkDateTime(format);
        log.info("{}", companyVO);
        companyService.register(companyVO);

//        퇴근 시간이면 퇴근 : 땡땡이
        return new RedirectView(lateCondition ? "/company/leave-work" : "/company/work");

    }

}













