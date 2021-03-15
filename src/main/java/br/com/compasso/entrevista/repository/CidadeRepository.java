package br.com.compasso.entrevista.repository;

import br.com.compasso.entrevista.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    @Query("select cidade from Cidade cidade where lower(:nome) = lower(cidade.nome) ")
    Cidade findByNomeIgnoreCase(String nome); // JPQL

    List<Cidade> findByEstadoIgnoreCase(String estado); // SPRING DATA
}
