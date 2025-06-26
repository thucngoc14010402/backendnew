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

    @PostMapping("/login")
    public Member login(@RequestBody LoginRequest loginRequest) {
        Member member = memberService.findByPhoneNumberAndPassword(loginRequest.getPhoneNumber(), loginRequest.getPassword());
        if (member == null) {
            throw new RuntimeException("Invalid phone number or password");
        }
        return member; // In production, return a JWT token instead
    }
}

class LoginRequest {
    private String phoneNumber;
    private String password;

    // Getters and setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}