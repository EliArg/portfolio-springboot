package com.ap.portfolio.model;

import java.time.LocalDate;
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
@Table(name="proyecto")
public class Proyecto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long id_pr;
    @Column(name="proyecto")
    private String proyecto;
    @Column(name="fin_pr")
    private LocalDate fin_pr;
    @Column(name="descripcion_pr")
    private String descripcion_pr;
    @Column(name="link")
    private String link;
    @Column(name="fuente")
    private String fuente;
    
    public Proyecto(){
    }
    public Proyecto(Long id_pr, String proyecto, LocalDate fin_pr, String descripcion_pr, String link, String fuente){
        this.id_pr = id_pr;
        this.proyecto = proyecto;
        this.fin_pr = fin_pr;
        this.descripcion_pr = descripcion_pr;
        this.link = link;
        this.fuente = fuente;
    }
}