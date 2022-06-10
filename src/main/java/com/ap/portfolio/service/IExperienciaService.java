package com.ap.portfolio.service;

import com.ap.portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {
    public List<Experiencia> verExperiencia();
    public void crearExperiencia(Experiencia exp);
    public void borrarExperiencia(Long id_ex);
    public Experiencia buscarExperiencia(Long id_ex);
    public void editarExperiencia(Long id_ex, Experiencia exp);
}
