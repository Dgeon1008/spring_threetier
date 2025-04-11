package com.app.threetier.controller;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.domain.ProductVO;
import com.app.threetier.mapper.MemberMapper;
import com.app.threetier.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/member/*")
@Slf4j
@RequiredArgsConstructor
public class MemberController {

//    테스트가 아니기때문에 생성자주입
    private final MemberMapper memberMapper;
//    로그인 정보 담기
    private final HttpSession session;
    private final MemberService memberService;

//    회원가입

//    가는거
//    forward
    @GetMapping("join")
    public void goToJoinForm(MemberVO memberVO) {;}


//    post로 오는거
//    redirect
    @PostMapping("join")
    public RedirectView join(MemberVO memberVO) {
        log.info(memberVO.toString());
        memberMapper.insert(memberVO);
//      return "forward:/member/login"; 포워드
//      redirect 처리방법
        return new RedirectView("/member/login");

    }

//    로그인 페이지 이동
    @GetMapping("login")
    public void goToLogin(MemberVO memberVO) {;}

//    로그인
    @PostMapping("login")
    public RedirectView login(MemberVO memberVO, RedirectAttributes redirectAttributes) {
        log.info(memberVO.toString());
        Optional<MemberVO> foundMember = memberMapper.select(memberVO);
//        로그인 성공
        if(foundMember.isPresent()) {
//            세션에 멤버VO 메모리 주소값을 넣는다
            session.setAttribute("member", foundMember.get());
            session.setAttribute("product", new ProductVO());
            return new RedirectView("/post/list");
        }
//        *로그인 실패
//        session.flash 영역
//        session이 과부화 되므로, session에 flash 영역을 사용하여
//        화면으로 상태 값을 보내고, new Request가 되면 session에 flash 값이 새로 주입되며 기존 flash 값이 사라진다.
//        따라서 과부화의 부담이 줄어든다.
        redirectAttributes.addFlashAttribute("login", false);
        return new RedirectView("/member/login");
    }

//    로그아웃
    @GetMapping("logout")
    public RedirectView logout() {
//        session.removeAttribute("member");
//        세션을 비워버린다 .invalidate
        session.invalidate();
        return new RedirectView("/member/login");
    }

//    회원탈퇴
    @GetMapping("withdraw")
    public RedirectView withdraw() {
        memberService.withdraw(((MemberVO)session.getAttribute("member")).getId());
        return new RedirectView("/member/login");
    }

}












