package org.example;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import java.io.Serializable;

// CON ESTO LE DECIMOS A JSONB UN ORDEN EN EL OBJETO QUE SE SERIALIZA
@JsonbPropertyOrder({"nome", "idade", "cidade"})
public class Persona implements Serializable {

    private String nome;
    private int idade;
    private String cidade;

    public Persona(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCidade() {
        return cidade;
    }

    }

