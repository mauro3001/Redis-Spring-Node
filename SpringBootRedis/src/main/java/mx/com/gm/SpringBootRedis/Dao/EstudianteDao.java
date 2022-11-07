package mx.com.gm.SpringBootRedis.Dao;

import mx.com.gm.SpringBootRedis.Domain.Estudiante;

import java.util.List;

public interface EstudianteDao{
    public boolean guardar(Estudiante estudiante);

    public List<Estudiante> listarEstudiantes();

}
