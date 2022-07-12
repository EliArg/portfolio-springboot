
package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Proyecto;
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
import com.ap.portfolio.repository.ProyectoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ProyectoController {
    @Autowired
    private ProyectoRepository repositorio;
    
    @GetMapping ("/proyecto")
    public List<Proyecto> verProyecto(){
        return repositorio.findAll();
    }
    @PostMapping ("/proyecto")
    public Proyecto crearProyecto(@RequestBody Proyecto pr){
        return repositorio.save(pr);
    }
    @GetMapping ("/proyecto/{id_pr}")
    public ResponseEntity<Proyecto> buscarProyecto(@PathVariable Long id_pr){
        Proyecto pr = repositorio.findById(id_pr).orElse(null);
        return ResponseEntity.ok(pr);       
    }
    @PutMapping ("/proyecto/{id_pr}")
    public ResponseEntity<Proyecto> editarProyecto(@PathVariable Long id_pr, @RequestBody Proyecto detallesPr){
        Proyecto pr = repositorio.findById(id_pr)
                .orElseThrow(null);
        pr.setNombre_pr(detallesPr.getNombre_pr());
        pr.setFin_pr(detallesPr.getFin_pr());
        pr.setDescripcion_pr(detallesPr.getDescripcion_pr());
        pr.setLink(detallesPr.getLink());
        pr.setFuente(detallesPr.getFuente());
        Proyecto prActualizada = repositorio.save(pr);
        return ResponseEntity.ok(prActualizada);       
    }
    @DeleteMapping("/proyecto/{id_pr}")
	public ResponseEntity<Map<String,Boolean>> eliminarProyecto(@PathVariable Long id_pr){
		Proyecto pr = repositorio.findById(id_pr)
				            .orElseThrow(null);
		
		repositorio.delete(pr);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
