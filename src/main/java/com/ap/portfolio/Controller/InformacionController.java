
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Informacion;
import com.ap.portfolio.repository.InformacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class InformacionController {
    @Autowired
    private InformacionRepository repositorio;
    
    @GetMapping ("/informacion")
    public List<Informacion> verInformacion(){
        return repositorio.findAll();
    }
    @PostMapping ("/informacion")
    public Informacion crearInformacion(@RequestBody Informacion info){
        return repositorio.save(info);
    }
    @PutMapping ("/informacion/{id}")
    public ResponseEntity<Informacion> editarInformacion(@PathVariable Long id, @RequestBody Informacion detallesInfo){
        Informacion info = repositorio.findById(id)
                .orElseThrow(null);
        info.setNombre(detallesInfo.getNombre());
        info.setTitulo(detallesInfo.getTitulo());
        info.setBanner(detallesInfo.getBanner());
        info.setAvatar(detallesInfo.getAvatar());
        info.setSobre_mi(detallesInfo.getSobre_mi());
        Informacion infoActualizada = repositorio.save(info);
        return ResponseEntity.ok(infoActualizada);       
    }
    
}
