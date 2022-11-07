package mx.com.gm.SpringBootRedis.Domain;


import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class Estudiante implements Serializable {
    @Id
    private Long codigo;
    private String nombre;
    private String email;
    private String carrera;
    private String nivel;

}
