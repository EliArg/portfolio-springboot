package com.ap.portfolio.service;

import com.ap.portfolio.model.Habilidad;
import java.util.List;

public interface IHabilidadService {
    public List<Habilidad> verHabilidad();
    public void crearHabilidad(Habilidad hab);
    public void borrarHabilidad(Long id_hab);
    public Habilidad buscarHabilidad(Long id_hab);
    public void editarHabilidad(Long id_hab, Habilidad hab);
}
