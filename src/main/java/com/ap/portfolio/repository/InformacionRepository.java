package com.ap.portfolio.repository;

import com.ap.portfolio.model.Informacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformacionRepository extends JpaRepository <Informacion, Long>{
    
}