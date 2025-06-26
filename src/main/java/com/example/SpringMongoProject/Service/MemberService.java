package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Member;
import com.example.SpringMongoProject.Repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public Member saveMember(Member member) {
        return repository.save(member);
    }

    public Member findByPhoneNumberAndPassword(String phoneNumber, String password) {
        return repository.findByPhoneNumberAndPassword(phoneNumber, password);
    }
}