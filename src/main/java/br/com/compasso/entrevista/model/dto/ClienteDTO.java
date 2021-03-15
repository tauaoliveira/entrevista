package br.com.compasso.entrevista.model.dto;

import br.com.compasso.entrevista.model.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ClienteDTO {

    private Integer id;
    private String nome;
    private String sexo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR")
    private LocalDate dataNascimento;
    private Integer idade;
    private String cidade;

    public Cliente toCliente() {
        Cliente cliente = new Cliente();
        cliente.setNome(getNome());
        cliente.setSexo(getSexo());
        cliente.setDataNascimento(getDataNascimento());
        cliente.setIdade(getIdade());

        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
