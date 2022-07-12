package com.ap.portfolio.security.entity;

import com.ap.portfolio.security.enums.RolNombre;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id_rol;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "nombre_rol")
    private RolNombre rolNombre;

    public Rol() {
    }

    public Rol(@NotNull RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public int getId() {
        return id_rol;
    }

    public void setId(int id_rol) {
        this.id_rol = id_rol;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
}