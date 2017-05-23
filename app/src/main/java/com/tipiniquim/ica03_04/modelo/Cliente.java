package com.tipiniquim.ica03_04.modelo;

/**
 * Created by marco on 22/05/2017.
 */

public class Cliente {

    private int idCliente;
    private String nome;
    private String email;
    private String endereco;
    private int idade;
    private int cpf;

    public int getidCliente() {
        return idCliente;
    }

    public void setIdCliente(int idUsuario) {
        this.idCliente = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String toString(){
        return "Nome: " + this.nome;
    }
}
