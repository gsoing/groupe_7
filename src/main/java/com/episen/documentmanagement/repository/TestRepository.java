package com.episen.documentmanagement.repository;

import com.episen.documentmanagement.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, String> {
}
