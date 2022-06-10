package com.ap.portfolio.service;

import com.ap.portfolio.model.Informacion;
import java.util.List;

public interface IInformacionService {
    public List<Informacion> verInformacion();
    public void crearInformacion(Informacion info);
    public void editarInformacion(Long id, Informacion info);
}
