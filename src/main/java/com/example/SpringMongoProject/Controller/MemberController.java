package com.example.SpringMongoProject.Controller;

import com.example.SpringMongoProject.Entity.Member;
import com.example.SpringMongoProject.Service.MemberService;
import com.example.SpringMongoProject.dto.ResetPasswordRequest;
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
        return member;
    }

    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestBody ForgotPasswordRequest request) {
        return memberService.requestPasswordReset(request.getPhoneNumber());
    }

    @PostMapping("/reset-password")
    public boolean resetPassword(@RequestBody ResetPasswordRequest request) {
        return memberService.resetPassword(request.getPhoneNumber(), request.getResetCode(), request.getNewPassword());
    }
}