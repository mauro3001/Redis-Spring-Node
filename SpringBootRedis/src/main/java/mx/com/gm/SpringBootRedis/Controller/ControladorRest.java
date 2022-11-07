package mx.com.gm.SpringBootRedis.Controller;

import mx.com.gm.SpringBootRedis.Domain.Estudiante;
import mx.com.gm.SpringBootRedis.Service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estudiantes")
public class ControladorRest {
    @Autowired
    private EstudianteService estudianteService;

    @GetMapping(value = "/lista")
    public ResponseEntity<List<Estudiante>> listarEstudiantes(){
        List<Estudiante> estudiantes;
        estudiantes = estudianteService.listarEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @PostMapping(value = "/guardar")
    public ResponseEntity<String> guardar(@RequestBody Estudiante estudiante){
        boolean result = estudianteService.guardar(estudiante);
        if(result)
            return ResponseEntity.ok("El estudiante a sido guardado Correctamente");
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
