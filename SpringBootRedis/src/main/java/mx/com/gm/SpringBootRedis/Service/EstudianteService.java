package mx.com.gm.SpringBootRedis.Service;

import mx.com.gm.SpringBootRedis.Domain.Estudiante;

import java.util.List;

public interface EstudianteService {
    public List<Estudiante> listarEstudiantes();

    public boolean guardar(Estudiante estudiante);

}
