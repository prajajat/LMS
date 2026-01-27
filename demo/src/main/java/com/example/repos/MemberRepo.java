package com.example.repos;

import com.example.entites.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepo extends JpaRepository<Member,Long> {
}
