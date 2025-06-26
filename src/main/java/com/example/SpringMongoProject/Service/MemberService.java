package com.example.SpringMongoProject.Service;

import com.example.SpringMongoProject.Entity.Member;
import com.example.SpringMongoProject.Repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

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

    public String requestPasswordReset(String phoneNumber) {
        Member member = repository.findByPhoneNumber(phoneNumber);
        if (member == null) {
            throw new RuntimeException("Số điện thoại không tồn tại");
        }
        // Giả lập tạo mã xác nhận (6 chữ số)
        String resetCode = String.format("%06d", new Random().nextInt(999999));
        // Trong thực tế, gửi resetCode qua SMS hoặc email
        System.out.println("Mã xác nhận cho " + phoneNumber + ": " + resetCode); // Log để kiểm tra
        return resetCode; // Trả về mã để client xử lý (thay bằng gửi SMS)
    }
}