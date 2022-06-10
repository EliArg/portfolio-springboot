package com.ap.portfolio.service;

import com.ap.portfolio.model.Habilidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ap.portfolio.repository.HabilidadRepository;
@Service
public class HabilidadService implements IHabilidadService {

    @Autowired
    public HabilidadRepository habRepo;
    
    @Override
    public List<Habilidad> verHabilidad() {
        return habRepo.findAll();
    }

    @Override
    public void crearHabilidad(Habilidad hab) {
        habRepo.save(hab);
    }

    @Override
    public void borrarHabilidad(Long id_hab) {
        habRepo.deleteById(id_hab);
    }

    @Override
    public Habilidad buscarHabilidad(Long id_hab) {
        return habRepo.findById(id_hab).orElse(null);
    }
    @Override
    public void editarHabilidad(Long id_hab, Habilidad hab) {
        habRepo.save(hab);
    }
}
