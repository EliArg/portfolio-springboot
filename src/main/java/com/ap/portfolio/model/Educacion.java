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
@Table(name="educacion")
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_ed")
    @javax.persistence.Id
    private Long id_ed;
    @Column(name="curso")
    private String curso;
    @Column(name="institucion_n")
    private String institucion_n;
    @Column(name="institucion_l")
    private String institucion_l;
    @Column(name="inicio_ed")
    private LocalDate inicio_ed;
    @Column(name="fin_ed")
    private LocalDate fin_ed;
    @Column(name="descripcion_ed")
    private String descripcion_ed;
    
    public Educacion(){
    }
    public Educacion(Long id_ed, String curso, String institucion_n, String institucion_l, LocalDate inicio_ed, LocalDate fin_ed, String descripcion_ed){
        this.id_ed = id_ed;
        this.curso = curso;
        this.institucion_n = institucion_n;
        this.institucion_l = institucion_l;
        this.inicio_ed = inicio_ed;
        this.fin_ed = fin_ed;
        this.descripcion_ed = descripcion_ed;
    }
}
