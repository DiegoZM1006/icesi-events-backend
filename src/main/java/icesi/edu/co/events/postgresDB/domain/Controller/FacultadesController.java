package icesi.edu.co.events.postgresDB.domain.Controller;

import icesi.edu.co.events.mongoDB.domain.Eventos;
import icesi.edu.co.events.postgresDB.domain.Facultades;
import icesi.edu.co.events.postgresDB.domain.repository.FacultadesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("facultades")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173/")
public class FacultadesController {

    private final FacultadesRepository facultadesRepository;

    @GetMapping(value = "getFacultades")
    public ResponseEntity<?> getFacultad(){
        List<Facultades> facultades = facultadesRepository.findAll();
        return  new ResponseEntity<>(facultades, HttpStatus.OK);
    }

    @GetMapping(value = "getFacultad/{id}")
    public ResponseEntity<?> getFacultad(@PathVariable("id") String id){
        Facultades facultad = facultadesRepository.findById(Integer.valueOf(id)).get();
        return new ResponseEntity<>(facultad, HttpStatus.OK);
    }
}
