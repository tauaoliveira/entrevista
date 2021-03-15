package br.com.compasso.entrevista.controller;

import br.com.compasso.entrevista.model.Cidade;
import br.com.compasso.entrevista.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        Cidade cidadeSalva = cidadeService.save(cidade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cidadeSalva.getId()).toUri();
        return ResponseEntity.created(uri).body(cidadeSalva);
    }

    @GetMapping("/find-by-nome/{nome}")
    public ResponseEntity<Cidade> findByName(@PathVariable String nome) {
        Cidade cidade = cidadeService.findByNome(nome);
        return ResponseEntity.ok(cidade);
    }

    @GetMapping("/find-by-estado/{estado}")
    public ResponseEntity<List<Cidade>> findByEstado(@PathVariable String estado) {
        List<Cidade> cidades = cidadeService.findByEstado(estado);
        return ResponseEntity.ok(cidades);
    }
}
