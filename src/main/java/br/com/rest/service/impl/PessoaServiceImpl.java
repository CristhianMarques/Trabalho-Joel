package br.com.rest.service.impl;

import br.com.rest.exception.RestNoContentException;
import br.com.rest.exception.RestNotFoundException;
import br.com.rest.model.Pessoa;
import br.com.rest.repository.PessoaRepository;
import br.com.rest.service.PessoaService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class PessoaServiceImpl implements PessoaService{

    @Autowired
    private PessoaRepository repository;    
    
    

    @Override
    public Pessoa save(Pessoa pessoa) {
        
        return repository.save(pessoa);
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
       
        return repository.save(pessoa);
    }

    @Override
    public void remove(Long id) {
        Pessoa pessoa = repository.findOne(id);
        pessoa.setId(id);
        if(pessoa == null){
            throw new RestNotFoundException("Registro não encontrado no banco de dados");
        }
        repository.delete(pessoa);
    }

    @Override
    public Pessoa findOne(Long id) {
        Pessoa pessoa = repository.findOne(id);
        pessoa.setId(id);
        
        if(pessoa == null){
            throw new RestNotFoundException("Registro não encontrado no banco de dados");
        }
        return pessoa;
    }

    @Override
    public Collection<Pessoa> findAll() {
        Collection<Pessoa> pessoas = repository.findAll();
       if(pessoas.isEmpty()){
           throw new RestNoContentException();
    }
        return pessoas;
    }
    
}
