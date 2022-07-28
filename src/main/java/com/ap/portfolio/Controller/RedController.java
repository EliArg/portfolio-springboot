package com.ap.portfolio.Controller;

import com.ap.portfolio.model.Red;
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
import com.ap.portfolio.repository.RedRepository;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@CrossOrigin(origins = "https://portfolio-eliarg.web.app/")
public class RedController {
    @Autowired
    private RedRepository repositorio;
    
    @GetMapping ("/red")
    public List<Red> verRed(){
        return repositorio.findAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/red")
    public Red crearRed(@RequestBody Red red){
        return repositorio.save(red);
    }
    @GetMapping ("/red/{id_red}")
    public ResponseEntity<Red> buscarRed(@PathVariable Long id_red){
        Red red = repositorio.findById(id_red).orElse(null);
        return ResponseEntity.ok(red);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/red/{id_red}")
    public ResponseEntity<Red> editarRed(@PathVariable Long id_red, @RequestBody Red detallesRed){
        Red red = repositorio.findById(id_red)
                .orElseThrow(null);
        red.setNombre_red(detallesRed.getNombre_red());
        red.setLink_red(detallesRed.getLink_red());
        Red redActualizada = repositorio.save(red);
        return ResponseEntity.ok(redActualizada);       
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/red/{id_red}")
	public ResponseEntity<Map<String,Boolean>> eliminarRed(@PathVariable Long id_red){
		Red red = repositorio.findById(id_red)
				            .orElseThrow(null);
		
		repositorio.delete(red);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
    
}
