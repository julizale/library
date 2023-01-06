package com.library;

import com.library.domain.Member;
import com.library.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
public class MemberTestSuite {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void testBookRepositoryFindAll() {
        // Given
        Member member = new Member();
        memberRepository.save(member);
        long memberId = member.getId();

        //When
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        //Then
        assertTrue(optionalMember.isPresent());

        //Cleanup
        memberRepository.deleteById(memberId);
    }

    @Test
    void testMemberRepositoryFindById() {
        //Given
        Member member = new Member();
        memberRepository.save(member);
        long memberId = member.getId();
        //When
        Optional<Member> memberFoundById = memberRepository.findById(memberId);
        //Then
        assertTrue(memberFoundById.isPresent());
        //Cleanup
        memberRepository.deleteById(memberId);
    }

    @Test
    void testMemberRepositorySave() {
        //Given
        Member member = new Member();

        //When
        memberRepository.save(member);
        long memberId = member.getId();

        //Then
        try {
            assertNotEquals(0, memberId);
        } finally {
            memberRepository.deleteById(memberId);
        }
    }

    @Test
    void testMemberRepositoryDeleteById() {
        //Given
        Member member = new Member();
        memberRepository.save(member);
        long memberId = member.getId();

        //When
        memberRepository.deleteById(memberId);
        Optional<Member> memberFoundById = memberRepository.findById(memberId);

        //Then
        assertFalse(memberFoundById.isPresent());
    }
}
