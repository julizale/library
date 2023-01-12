package com.library.service;

import com.library.domain.Member;
import com.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberDbService {

    private MemberRepository memberRepository;

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }
}
