package br.com.rest.api.v2.controller;

import br.com.rest.model.Pessoa;
import br.com.rest.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.Collection;

@RestController
@RequestMapping("/api/v2")
public class PessoaControllerV2 {

    @Autowired
    private PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findOne(@PathParam("id") Long id) {      
            return ResponseEntity
                    .ok(service.findOne(id));
    }

}
