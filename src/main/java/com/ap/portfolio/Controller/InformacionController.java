
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Informacion;
import com.ap.portfolio.repository.InformacionRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://portfolio-eliarg.web.app/")
public class InformacionController {
    @Autowired
    private InformacionRepository repositorio;
    
    @GetMapping ("/informacion")
    public List<Informacion> verInformacion(){
        return repositorio.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/informacion")
    public Informacion crearInformacion(@RequestBody Informacion info){
        return repositorio.save(info);
    }
    @GetMapping ("/informacion/{id}")
    public ResponseEntity<Informacion> buscarInformacion(@PathVariable Long id){
        Informacion info = repositorio.findById(id).orElse(null);
        return ResponseEntity.ok(info);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/informacion/{id}")
    public ResponseEntity<Informacion> editarInformacion(@PathVariable Long id, @RequestBody Informacion detallesInfo){
        Informacion info = repositorio.findById(id)
                .orElseThrow(null);
        info.setNombre(detallesInfo.getNombre());
        info.setTitulo(detallesInfo.getTitulo());
        info.setEmail(detallesInfo.getEmail());
        info.setSobre_mi(detallesInfo.getSobre_mi());
        info.setBanner(detallesInfo.getBanner());
        info.setAvatar(detallesInfo.getAvatar());
        Informacion infoActualizada = repositorio.save(info);
        return ResponseEntity.ok(infoActualizada);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/informacion/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarInformacion(@PathVariable Long id){
		Informacion info = repositorio.findById(id)
				            .orElseThrow(null);
		
		repositorio.delete(info);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
}
