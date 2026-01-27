package com.example.repos;

import com.example.entites.MemberProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProfileRepo extends JpaRepository<MemberProfile,Long> {
}
