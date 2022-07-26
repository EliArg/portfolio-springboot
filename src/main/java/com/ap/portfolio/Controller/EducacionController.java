
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Educacion;
import com.ap.portfolio.repository.EducacionRepository;
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
@CrossOrigin(origins = "http://localhost:4200/")
public class EducacionController {
    @Autowired
    private EducacionRepository repositorio;
    
    @GetMapping ("/educacion")
    public List<Educacion> verEducacion(){
        return repositorio.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/educacion")
    public Educacion crearEducacion(@RequestBody Educacion edu){
        return repositorio.save(edu);
    }
    @GetMapping ("/educacion/{id_ed}")
    public ResponseEntity<Educacion> buscarEducacion(@PathVariable Long id_ed){
        Educacion edu = repositorio.findById(id_ed).orElse(null);
        return ResponseEntity.ok(edu);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/educacion/{id_ed}")
    public ResponseEntity<Educacion> editarEducacion(@PathVariable Long id_ed, @RequestBody Educacion detallesEdu){
        Educacion edu = repositorio.findById(id_ed)
                .orElseThrow(null);
        edu.setCurso(detallesEdu.getCurso());
        edu.setInstitucion_n(detallesEdu.getInstitucion_n());
        edu.setInstitucion_l(detallesEdu.getInstitucion_l());
        edu.setInicio_ed(detallesEdu.getInicio_ed());
        edu.setFin_ed(detallesEdu.getFin_ed());
        edu.setDescripcion_ed(detallesEdu.getDescripcion_ed());
        Educacion eduActualizada = repositorio.save(edu);
        return ResponseEntity.ok(eduActualizada);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/educacion/{id_ed}")
	public ResponseEntity<Map<String,Boolean>> eliminarEducacion(@PathVariable Long id_ed){
		Educacion edu = repositorio.findById(id_ed)
				            .orElseThrow(null);
		
		repositorio.delete(edu);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
