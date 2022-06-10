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
@Table(name="informacion")
public class Informacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id;
    @Column(name="nombre")
    private String nombre;
    @Column(name="titulo")
    private String titulo;
    @Column(name="banner")
    private String banner;
    @Column(name="avatar")
    private String avatar;
    @Column(name="sobre_mi")
    private String sobre_mi;
    
    public Informacion(){
    }
    public Informacion(Long id, String nombre, String titulo, String banner, String avatar, String sobre_mi){
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.banner = banner;
        this.avatar = avatar;
        this.sobre_mi = sobre_mi;
    }
}