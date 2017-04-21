package br.com.rest.api.v1.controller;

import br.com.rest.model.Pessoa;
import br.com.rest.service.PessoaService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1" )
public class PessoaController {

    @Autowired
    private PessoaService service;
    
   

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@Valid @RequestBody Pessoa pessoa ) {
        pessoa.setId(null);
        
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(service.save(pessoa)
                    
                    );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody Pessoa pessoa) {
        pessoa.setId(id);
        
            service.findOne(id);
            return ResponseEntity
                    .ok(service.update(pessoa));
        
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") Long id) {
        
            service.remove(id);
            return ResponseEntity
                    .noContent()
                    .build();
            
        

    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)//,headers="teste=application")
    public ResponseEntity findOne(@PathVariable("id") Long id) {
        
            return ResponseEntity
                   
                    .ok(service.findOne(id));
        
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        Collection<Pessoa> pessoas = service.findAll();
        if (pessoas.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity.ok(pessoas);
    }
}
