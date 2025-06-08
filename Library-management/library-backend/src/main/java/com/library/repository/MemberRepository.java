package com.library.repository;

import com.library.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
    // You can add custom queries here if needed
}
