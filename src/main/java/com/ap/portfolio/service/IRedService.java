package com.ap.portfolio.service;

import com.ap.portfolio.model.Red;
import java.util.List;

public interface IRedService {
    public List<Red> verRed();
    public void crearRed(Red red);
    public void borrarRed(Long id_red);
    public Red buscarRed(Long id_red);
    public void editarRed(Long id_red, Red red);
}
