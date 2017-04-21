/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rest.repository;

import br.com.rest.model.Pessoa;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CaroleCristhian
 */
@Repository
public interface PessoaRepository  extends JpaRepository<Pessoa, Long>{
     Pessoa findByNome(String nome);
    
   
    
}
