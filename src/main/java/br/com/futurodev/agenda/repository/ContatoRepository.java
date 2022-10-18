package br.com.futurodev.agenda.repository;

import br.com.futurodev.agenda.model.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {
  @Query(value = "select c from Contato c where c.nome like %?1%")
    ArrayList<Contato> getContatoByName(String nome);
}
