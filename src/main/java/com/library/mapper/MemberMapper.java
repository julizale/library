package com.library.mapper;

import com.library.domain.Member;
import com.library.domain.dto.MemberDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberMapper {

    public MemberDto mapToMemberDto(Member member) {
        return new MemberDto(
                member.getId(),
                member.getFirstName(),
                member.getLastName(),
                member.getAccountCreated()
        );
    }

    public Member mapToMember(MemberDto memberDto) {
        return new Member(
                memberDto.getId(),
                memberDto.getFirstName(),
                memberDto.getLastName(),
                memberDto.getAccountCreated(),
                new ArrayList<>()
        );
    }

    public List<MemberDto> mapToMemberDtoList(List<Member> members) {
        return members.stream()
                .map(this::mapToMemberDto)
                .toList();
    }
}
