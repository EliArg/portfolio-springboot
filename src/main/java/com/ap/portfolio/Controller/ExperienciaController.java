
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Experiencia;
import com.ap.portfolio.repository.ExperienciaRepository;
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

@RestController
@CrossOrigin(origins = "https://portfolio-eliarg.web.app/")
public class ExperienciaController {
    @Autowired
    private ExperienciaRepository repositorio;
    
    @GetMapping ("/experiencia")
    public List<Experiencia> verExperiencia(){
        return repositorio.findAll();
    }
    @PostMapping ("/experiencia")
    public Experiencia crearExperiencia(@RequestBody Experiencia exp){
        return repositorio.save(exp);
    }
    @GetMapping ("/experiencia/{id_ex}")
    public ResponseEntity<Experiencia> buscarExperiencia(@PathVariable Long id_ex){
        Experiencia exp = repositorio.findById(id_ex).orElse(null);
        return ResponseEntity.ok(exp);       
    }
    @PutMapping ("/experiencia/{id_ex}")
    public ResponseEntity<Experiencia> editarExperiencia(@PathVariable Long id_ex, @RequestBody Experiencia detallesExp){
        Experiencia exp = repositorio.findById(id_ex)
                .orElseThrow(null);
        exp.setTrabajo(detallesExp.getTrabajo());
        exp.setEmpresa_n(detallesExp.getEmpresa_n());
        exp.setEmpresa_l(detallesExp.getEmpresa_l());
        exp.setInicio_ex(detallesExp.getInicio_ex());
        exp.setFin_ex(detallesExp.getFin_ex());
        exp.setDescripcion_ex(detallesExp.getDescripcion_ex());
        Experiencia expActualizada = repositorio.save(exp);
        return ResponseEntity.ok(expActualizada);       
    }
    @DeleteMapping("/experiencia/{id_ex}")
	public ResponseEntity<Map<String,Boolean>> eliminarExperiencia(@PathVariable Long id_ex){
		Experiencia exp = repositorio.findById(id_ex)
				            .orElseThrow(null);
		
		repositorio.delete(exp);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
