package com.ap.portfolio.service;

import com.ap.portfolio.model.Educacion;
import java.util.List;

public interface IEducacionService {
    public List<Educacion> verEducacion();
    public void crearEducacion(Educacion edu);
    public void borrarEducacion(Long id_ed);
    public Educacion buscarEducacion(Long id_ed);
    public void editarEducacion(Long id_ed, Educacion edu);
}
