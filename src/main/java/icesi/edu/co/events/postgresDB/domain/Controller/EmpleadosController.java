package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.postgresDB.domain.Empleados;
import icesi.edu.co.events.postgresDB.domain.Usuarios;
import icesi.edu.co.events.postgresDB.domain.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("empleados")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class EmpleadosController {

    private final EmpleadosRepository empleadosRepository;

    @GetMapping(value = "allEmpleados")
    public List<Empleados> getAllEmpleados(){
        List<Empleados> empleadosLista = empleadosRepository.findAll();
        return empleadosLista;
    }

    @GetMapping(value = "/{id}")
    public Optional<Empleados> getOneEmpleados(@PathVariable("id") String id){
        Optional<Empleados> empleados = empleadosRepository.findById(id);
        return empleados;
    }

    @GetMapping(value = "/exists/{id}")
    public boolean getOneEmpleadosTorF(@PathVariable("id") String id) {
        return empleadosRepository.existsById(id);
    }


}
