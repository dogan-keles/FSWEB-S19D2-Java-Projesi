package com.workintech.bankAuth.controller;

import com.workintech.bankAuth.dto.RegistrationMember;
import com.workintech.bankAuth.entity.Member;
import com.workintech.bankAuth.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private MemberService memberService;
@Autowired
    public AuthController(MemberService memberService) {
        this.memberService = memberService;
    }
    @PostMapping("/register")
    public Member register(@RequestBody RegistrationMember registrationMember){
    return memberService.register(registrationMember.email(), registrationMember.password());
    }
}