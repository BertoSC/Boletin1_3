package org.example;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

// CON ESTO LE DECIMOS A JSONB UN ORDEN EN EL OBJETO QUE SE SERIALIZA
@JsonbPropertyOrder({"nome", "idade", "g"})
public class Proba implements Serializable {

    private String nome;
    private int idade;
    private Date g;

    public Proba(String nome, int idade, Date g) {
        this.nome = nome;
        this.idade = idade;
        this.g = g;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Date getG() {
        return g;
    }

}

