package br.com.rest.repository;

import br.com.rest.model.Contato;
import br.com.rest.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author CaroleCristhian
 */
@Repository
public interface ContatoRepository  extends JpaRepository<Contato, Long>{
    
    @Query("select id,celular,email,fixo,cliente from Contato c where c.cliente = :cliente")
    Contato findBycliente(@Param("cliente") Long cliente); 
 
       
}
