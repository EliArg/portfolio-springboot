package com.ap.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter @Setter
@Entity
@Table(name="habilidad")
public class Habilidad {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id_hab;
    @Column(name="skill")
    private String skill;
    @Column(name="nivel")
    private Long nivel;
    
    public Habilidad(){
    }
    public Habilidad(Long id_hab, String skill, Long nivel){
        this.id_hab = id_hab;
        this.skill = skill;
        this.nivel = nivel;
    }
}
