package br.com.rest.service.impl;

import br.com.rest.exception.RestNoContentException;
import br.com.rest.exception.RestNotFoundException;
import br.com.rest.model.Contato;
import br.com.rest.model.Pessoa;
import br.com.rest.repository.ContatoRepository;
import br.com.rest.service.ContatoService;
import org.springframework.stereotype.Service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ContatoServiceImpl implements ContatoService{


    private ContatoRepository repository;    
    
    

    @Override
    public Contato save(Contato contatos) {
        
        return repository.save(contatos);
    }

    @Override
    public Contato update(Contato contato) {
       
        return repository.save(contato);
    }

    @Override
    public void remove(Long id) {
        Contato contato = repository.findOne(id);
        contato.setId(id);
        if(contato == null){
            throw new RestNotFoundException("Registro não encontrado no banco de dados");
        }
        repository.delete(contato);
    }

    @Override
    public Contato findOne(Long id) {
     
        Contato contato = repository.findBycliente(id);
        contato.setId(id);
        
        if(contato == null){
            throw new RestNotFoundException("Registro não encontrado no banco de dados");
        }
        return contato;
    }

    @Override
    public Collection<Contato> findAll() {
        Collection<Contato> contato = repository.findAll();
       if(contato.isEmpty()){
           throw new RestNoContentException();
    }
        return contato;
    }
    
}
