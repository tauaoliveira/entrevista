package br.com.compasso.entrevista.service;

import br.com.compasso.entrevista.exception.BadRequestException;
import br.com.compasso.entrevista.exception.ObjectNotFoundException;
import br.com.compasso.entrevista.model.Cidade;
import br.com.compasso.entrevista.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade save(Cidade cidade) {
        Cidade cidadeBanco = cidadeRepository.findByNomeIgnoreCase(cidade.getNome());
        if (cidadeBanco == null) {
            return cidadeRepository.save(cidade);
        }
        throw new BadRequestException("Já existe cidade cadastrada para o nome informado");
    }

    public Cidade findByNome(String nome) {
        Cidade cidade = cidadeRepository.findByNomeIgnoreCase(nome);
        if (cidade != null) {
            return cidade;
        }
        throw new ObjectNotFoundException("Não foram encontradas cidades para o nome informado");
    }

    public List<Cidade> findByEstado(String estado) {
        List<Cidade> cidades = cidadeRepository.findByEstadoIgnoreCase(estado);
        if (cidades != null && !cidades.isEmpty()) {
            return cidades;
        }
        throw new ObjectNotFoundException("Não foram encontradas cidades para o estado informado");
    }
}
