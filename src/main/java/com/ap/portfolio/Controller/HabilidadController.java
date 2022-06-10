
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Habilidad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ap.portfolio.repository.HabilidadRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class HabilidadController {
    @Autowired
    private HabilidadRepository repositorio;
    
    @GetMapping ("/habilidad")
    public List<Habilidad> verHabilidad(){
        return repositorio.findAll();
    }
    @PostMapping ("/habilidad")
    public Habilidad crearHabilidad(@RequestBody Habilidad hab){
        return repositorio.save(hab);
    }
    @GetMapping ("/habilidad/{id_hab}")
    public ResponseEntity<Habilidad> buscarHabilidad(@PathVariable Long id_hab){
        Habilidad hab = repositorio.findById(id_hab).orElse(null);
        return ResponseEntity.ok(hab);       
    }
    @PutMapping ("/habilidad/{id_hab}")
    public ResponseEntity<Habilidad> editarHabilidad(@PathVariable Long id_hab, @RequestBody Habilidad detallesHab){
        Habilidad hab = repositorio.findById(id_hab)
                .orElseThrow(null);
        hab.setSkill(detallesHab.getSkill());
        hab.setNivel(detallesHab.getNivel());
        Habilidad habActualizada = repositorio.save(hab);
        return ResponseEntity.ok(habActualizada);       
    }
    @DeleteMapping("/habilidad/{id_hab}")
	public ResponseEntity<Map<String,Boolean>> eliminarHabilidad(@PathVariable Long id_hab){
		Habilidad hab = repositorio.findById(id_hab)
				            .orElseThrow(null);
		
		repositorio.delete(hab);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
