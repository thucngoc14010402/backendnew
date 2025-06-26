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
        String resetCode = String.format("%06d", new Random().nextInt(999999));
        member.setResetCode(resetCode); // Lưu mã xác nhận vào Member
        repository.save(member); // Cập nhật vào MongoDB
        System.out.println("Mã xác nhận cho " + phoneNumber + ": " + resetCode);
        return resetCode;
    }

    public boolean resetPassword(String phoneNumber, String resetCode, String newPassword) {
        Member member = repository.findByPhoneNumber(phoneNumber);
        if (member == null) {
            throw new RuntimeException("Số điện thoại không tồn tại");
        }
        // So sánh với mã đã lưu
        if (!resetCode.equals(member.getResetCode())) {
            throw new RuntimeException("Mã xác nhận không đúng");
        }
        member.setPassword(newPassword); // Cập nhật mật khẩu (nên hash)
        member.setResetCode(null); // Xóa mã xác nhận sau khi sử dụng
        repository.save(member);
        return true;
    }
}