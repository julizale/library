package com.library.controller;

import com.library.domain.Member;
import com.library.domain.dto.MemberDto;
import com.library.mapper.MemberMapper;
import com.library.service.MemberDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/members")
public class MemberController {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberDbService memberDbService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDto memberDto) {
        Member member = memberMapper.mapToMember(memberDto);
        memberDbService.saveMember(member);
        return ResponseEntity.ok().build();
    }
}
