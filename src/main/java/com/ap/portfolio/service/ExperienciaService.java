package com.ap.portfolio.service;

import com.ap.portfolio.model.Experiencia;
import com.ap.portfolio.repository.ExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ExperienciaService implements IExperienciaService {

    @Autowired
    public ExperienciaRepository expRepo;
    
    @Override
    public List<Experiencia> verExperiencia() {
        return expRepo.findAll();
    }

    @Override
    public void crearExperiencia(Experiencia exp) {
        expRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id_ex) {
        expRepo.deleteById(id_ex);
    }

    @Override
    public Experiencia buscarExperiencia(Long id_ex) {
        return expRepo.findById(id_ex).orElse(null);
    }
    @Override
    public void editarExperiencia(Long id_ex, Experiencia exp) {
        expRepo.save(exp);
    }
}
