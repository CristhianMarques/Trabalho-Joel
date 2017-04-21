package br.com.rest.service;

import br.com.rest.model.Pessoa;
import java.util.Collection;


public interface PessoaService {
    Pessoa save(Pessoa pessoa);
    Pessoa update(Pessoa pessoa);
    void remove(Long id);
    Pessoa findOne(Long id);
    Collection<Pessoa> findAll();
}
