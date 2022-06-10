package com.ap.portfolio.repository;

import com.ap.portfolio.model.Red;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedRepository extends JpaRepository <Red, Long>{
    
}