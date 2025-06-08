package com.library.repository;

import com.library.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource, String> {
    // You can add custom queries here if needed
}
