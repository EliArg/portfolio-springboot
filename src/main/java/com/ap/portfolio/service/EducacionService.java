package com.ap.portfolio.service;

import com.ap.portfolio.model.Educacion;
import com.ap.portfolio.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EducacionService implements IEducacionService {

    @Autowired
    public EducacionRepository eduRepo;
    
    @Override
    public List<Educacion> verEducacion() {
        return eduRepo.findAll();
    }

    @Override
    public void crearEducacion(Educacion edu) {
        eduRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id_ed) {
        eduRepo.deleteById(id_ed);
    }

    @Override
    public Educacion buscarEducacion(Long id_ed) {
        return eduRepo.findById(id_ed).orElse(null);
    }
    @Override
    public void editarEducacion(Long id_ed, Educacion edu) {
        eduRepo.save(edu);
    }
}
