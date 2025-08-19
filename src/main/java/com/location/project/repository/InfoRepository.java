package com.location.project.repository;

import com.location.project.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<Info, Long> {
    // Any custom queries or methods can be added here if needed
}