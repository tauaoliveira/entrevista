package br.com.compasso.entrevista.controller;

import br.com.compasso.entrevista.model.Cliente;
import br.com.compasso.entrevista.model.dto.ClienteDTO;
import br.com.compasso.entrevista.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteDTO dto) {
        Cliente clienteSalvo = clienteService.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clienteSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(clienteSalvo);
    }

    @PatchMapping
    public ResponseEntity<Cliente> update(@RequestBody ClienteDTO dto) {
        Cliente clienteSalvo = clienteService.update(dto);
        return ResponseEntity.ok(clienteSalvo);
    }

    @GetMapping("/find-by-nome/{nome}")
    public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nome) {
        List<Cliente> clientes = clienteService.findByNome(nome);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteById(@PathVariable Integer id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
