package com.ap.portfolio.service;

import com.ap.portfolio.model.Proyecto;
import java.util.List;

public interface IProyectoService {
    public List<Proyecto> verProyecto();
    public void crearProyecto(Proyecto pr);
    public void borrarProyecto(Long id_pr);
    public Proyecto buscarProyecto(Long id_pr);
    public void editarProyecto(Long id_pr, Proyecto pr);
}
