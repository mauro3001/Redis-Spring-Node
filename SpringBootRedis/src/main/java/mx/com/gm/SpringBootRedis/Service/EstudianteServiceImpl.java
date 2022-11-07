package mx.com.gm.SpringBootRedis.Service;

import mx.com.gm.SpringBootRedis.Dao.EstudianteDao;
import mx.com.gm.SpringBootRedis.Domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public List<Estudiante> listarEstudiantes(){
        return estudianteDao.listarEstudiantes();
    }
    @Override
    public boolean guardar(Estudiante estudiante){
        return estudianteDao.guardar(estudiante);
    }

}
