package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Member;
import com.example.SpringMongoProject.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/members")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping("/register")
    public Member registerMember(@RequestBody Member member) {
        return memberService.saveMember(member);
    }
}
