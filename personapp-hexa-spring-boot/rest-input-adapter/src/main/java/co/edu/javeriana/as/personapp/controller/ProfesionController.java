package co.edu.javeriana.as.personapp.controller;

import co.edu.javeriana.as.personapp.adapter.ProfesionInputAdapterRest;
import co.edu.javeriana.as.personapp.domain.Study;
import co.edu.javeriana.as.personapp.model.request.ProfesionRequest;
import co.edu.javeriana.as.personapp.model.response.ProfesionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/profeion")
public class ProfesionController {

    @Autowired
    private ProfesionInputAdapterRest profesionInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfesionResponse> profesiones(@PathVariable String database){
        log.info("Into profesion REST API");
        return profesionInputAdapterRest.historial(database.toUpperCase());
    }

    @ResponseBody
    @GetMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProfesionResponse crearProfesion(@RequestBody ProfesionRequest request, @RequestBody List<Study> studies){
        log.info("Into profesion create profesion controller");
        return profesionInputAdapterRest.crearProfesion(request,studies);
    }


}
