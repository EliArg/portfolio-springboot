package com.ap.portfolio.service;

import com.ap.portfolio.model.Red;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ap.portfolio.repository.RedRepository;
@Service
public class RedService implements IRedService {

    @Autowired
    public RedRepository redRepo;
    
    @Override
    public List<Red> verRed() {
        return redRepo.findAll();
    }

    @Override
    public void crearRed(Red red) {
        redRepo.save(red);
    }

    @Override
    public void borrarRed(Long id_red) {
        redRepo.deleteById(id_red);
    }

    @Override
    public Red buscarRed(Long id_red) {
        return redRepo.findById(id_red).orElse(null);
    }
    @Override
    public void editarRed(Long id_red, Red red) {
        redRepo.save(red);
    }
}
