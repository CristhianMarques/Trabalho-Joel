/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.api.v3.controller;

import br.com.rest.model.Contato;
import br.com.rest.model.Pessoa;
import br.com.rest.service.ContatoService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author CaroleCristhian
 */
@RestController
@RequestMapping("/pessoas" )
public class ContatoController {
    
    
    @Autowired
    private ContatoService service;
    
   

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity save(@Valid @RequestBody Contato contato ) {
        contato.setId(null);
          
       
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(service.save(contato)
                    
                    );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody Contato contato) {
        
        
        
            service.findOne(id);
            return ResponseEntity
                    .ok(service.update(contato));
        
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") Long id) {
        
            service.remove(id);
            return ResponseEntity
                    .noContent()
                    .build();
            
        

    }

    @RequestMapping(value = "{cliente}/contatos", method = RequestMethod.GET)//,headers="teste=application/json")
    public ResponseEntity findOne(@PathVariable("cliente") Long cliente) {
        
            return ResponseEntity
                   
                    .ok(service.findOne(cliente));
        
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        Collection<Contato> contato = service.findAll();
        if (contato.isEmpty()) {
            return ResponseEntity
                    .noContent()
                    .build();
        }
        return ResponseEntity.ok(contato);
    }
    
}
