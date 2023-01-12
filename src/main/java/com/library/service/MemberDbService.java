package com.library.service;

import com.library.domain.Member;
import com.library.exception.MemberNotFoundException;
import com.library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDbService {

    @Autowired
    private MemberRepository memberRepository;

    public Member getMember(long memberId) throws MemberNotFoundException {
        return memberRepository.findById(memberId).orElseThrow(MemberNotFoundException::new);
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
