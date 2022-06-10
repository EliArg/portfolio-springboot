package com.ap.portfolio.service;

import com.ap.portfolio.model.Informacion;
import com.ap.portfolio.repository.InformacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InformacionService implements IInformacionService {

    @Autowired
    public InformacionRepository infoRepo;
    
    @Override
    public List<Informacion> verInformacion() {
        return infoRepo.findAll();
    }
    @Override
    public void crearInformacion(Informacion info) {
        infoRepo.save(info);
    }
    @Override
    public void editarInformacion(Long id, Informacion info) {
        infoRepo.save(info);
    }
}
