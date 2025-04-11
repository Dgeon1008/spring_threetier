package com.app.threetier.service;

import com.app.threetier.domain.MemberVO;
import com.app.threetier.repository.MemberDAO;
import com.app.threetier.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

    //    회원가입
    @Override
    public void join(MemberVO memberVO) {
        memberDAO.save(memberVO);
    }

//    로그인
    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.findByMemberIdAndMemberPassword(memberVO);
    }

//    회원탈퇴
    @Override
//    원자성 오류발생시 모두 되돌리겠다.
//    @Transactional(rollbackFor = Exception.class)
//    @Transactional(rollbackFor = {IOException.class, RuntimeException.class})
    public void withdraw(Long id) {
//        회원이 탈퇴될때는 게시글도 모두 삭제되어야한다 = 서비스 하나
        postDAO.deleteAllByMemberId(id);
//        게시글 삭제후 멤버 삭제
        memberDAO.delete(id);

    }

}






