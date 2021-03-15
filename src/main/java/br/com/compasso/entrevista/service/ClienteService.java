package br.com.compasso.entrevista.service;

import br.com.compasso.entrevista.exception.ObjectNotFoundException;
import br.com.compasso.entrevista.model.Cidade;
import br.com.compasso.entrevista.model.Cliente;
import br.com.compasso.entrevista.model.dto.ClienteDTO;
import br.com.compasso.entrevista.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CidadeService cidadeService;

    public Cliente save(ClienteDTO dto) {
        Cidade cidade = cidadeService.findByNome(dto.getCidade());
        if (cidade != null) {
            Cliente cliente = dto.toCliente();
            cliente.setCidade(cidade);
            return clienteRepository.save(cliente);
        }
        throw new ObjectNotFoundException("Cidade informada não existe");
    }

    public Cliente update(ClienteDTO dto) {
        if (dto.getId() != null) {
            Cliente clienteBanco = findById(dto.getId());
            clienteBanco.setNome(dto.getNome());
            return clienteRepository.save(clienteBanco);
        }
        throw new ObjectNotFoundException("Não é possível alterar nome do cliente sem informar seu id");
    }

    public List<Cliente> findByNome(String nome) {
        Optional<List<Cliente>> optionalClientes = clienteRepository.findByNomeIgnoreCase(nome);
        if (optionalClientes.isPresent()) {
            List<Cliente> clientes = optionalClientes.get();
            if (!clientes.isEmpty()) {
                return clientes;
            }
        }
        throw new ObjectNotFoundException("Não existe cliente com o nome informado");
    }

    public Cliente findById(Integer id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Não existe cliente com o id informado"));
    }

    public void deleteById(Integer id) {
        clienteRepository.deleteById(id);
    }
}
