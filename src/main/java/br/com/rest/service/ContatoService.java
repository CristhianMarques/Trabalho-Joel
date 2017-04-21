package br.com.rest.service;


import br.com.rest.model.Contato;
import br.com.rest.model.Pessoa;
import java.util.Collection;


public interface ContatoService {
    Contato save(Contato contato);
    Contato update(Contato contato);
    void remove(Long id);
    Contato findOne(Long id);
    Collection<Contato> findAll();
}
