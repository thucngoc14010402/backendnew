package com.example.SpringMongoProject.Repo;

import com.example.SpringMongoProject.Entity.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MemberRepository extends MongoRepository<Member, String> {
}
