package com.ap.portfolio.service;

import com.ap.portfolio.model.Proyecto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ap.portfolio.repository.ProyectoRepository;
@Service
public class ProyectoService implements IProyectoService {

    @Autowired
    public ProyectoRepository prRepo;
    
    @Override
    public List<Proyecto> verProyecto() {
        return prRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyecto pr) {
        prRepo.save(pr);
    }

    @Override
    public void borrarProyecto(Long id_pr) {
        prRepo.deleteById(id_pr);
    }

    @Override
    public Proyecto buscarProyecto(Long id_pr) {
        return prRepo.findById(id_pr).orElse(null);
    }
    @Override
    public void editarProyecto(Long id_pr, Proyecto pr) {
        prRepo.save(pr);
    }
}
