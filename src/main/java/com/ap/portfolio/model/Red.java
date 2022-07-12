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
@Table(name="red")
public class Red {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id_red;
    @Column(name="nombre_red")
    private String nombre_red;
    @Column(name="link_red")
    private String link_red;
    
    public Red(){
    }
    public Red(Long id_red, String nombre_red, String link_red){
        this.id_red = id_red;
        this.nombre_red = nombre_red;
        this.link_red = link_red;
    }
}
