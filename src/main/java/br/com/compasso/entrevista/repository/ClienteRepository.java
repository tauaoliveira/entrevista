package br.com.compasso.entrevista.repository;

import br.com.compasso.entrevista.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    @Query(value = "select * from Cliente where lower(:nome) = lower(nome) ", nativeQuery = true) // NATIVE QUERY
    Optional<List<Cliente>> findByNomeIgnoreCase(String nome);
}
