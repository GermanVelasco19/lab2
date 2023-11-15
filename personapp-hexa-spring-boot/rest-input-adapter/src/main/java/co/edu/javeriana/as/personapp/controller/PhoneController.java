package co.edu.javeriana.as.personapp.controller;
import java.util.List;

import co.edu.javeriana.as.personapp.adapter.TelefonoInputAdapterRest;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.request.DeleteTelefonoRequest;
import co.edu.javeriana.as.personapp.model.request.GetTelefonoRequest;
import co.edu.javeriana.as.personapp.model.request.TelefonoRequest;
import co.edu.javeriana.as.personapp.model.response.TelefonoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/api/v1/telefono")
@Validated
public class PhoneController {

    @Autowired
    private TelefonoInputAdapterRest phoneInputAdapterRest;

    @ResponseBody
    @GetMapping(path = "/{database}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TelefonoResponse> personas(@Valid @PathVariable String database) {
        log.info("Into personas REST API");
        return phoneInputAdapterRest.historial(database);
    }

    @ResponseBody
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public TelefonoResponse crearPersona(@Valid @RequestBody TelefonoRequest request) {
        return phoneInputAdapterRest.crearTelefono(request);
    }

    @PutMapping
    public TelefonoResponse editPersona(@Valid @RequestBody TelefonoRequest request){
        log.info("Editando persona en el controller del api");
        return phoneInputAdapterRest.editTelefono(request);
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePersona(@Valid @RequestBody DeleteTelefonoRequest request){
        log.info("Eliminando persona con id {} del controller del api", request.getId());
        return phoneInputAdapterRest.deleteTelefono(request) ? ResponseEntity.ok().build(): ResponseEntity.badRequest().build();
    }

    @GetMapping
    public TelefonoResponse getOnePersona(@Valid @RequestBody GetTelefonoRequest request){
        log.info("Obteniendo la persona con id {} en el controller del api", request.getId());
        return phoneInputAdapterRest.getOnePerson(request);
    }

}