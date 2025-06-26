package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String> {
    Member findByPhoneNumberAndPassword(String phoneNumber, String password);
}