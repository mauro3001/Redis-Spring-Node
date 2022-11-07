package mx.com.gm.SpringBootRedis.Dao;

import mx.com.gm.SpringBootRedis.Domain.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstudianteDaoImplementation implements EstudianteDao{
    public static final String KEY = "Estudiante";
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<Estudiante> listarEstudiantes(){
        List<Estudiante> estudiantes;
        estudiantes = redisTemplate.opsForHash().values(KEY);
        return estudiantes;
    }

    @Override
    public boolean guardar(Estudiante estudiante){
        try{
            redisTemplate.opsForHash().put(KEY,estudiante.getCodigo().toString(),estudiante);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
