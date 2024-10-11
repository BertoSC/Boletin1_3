package org.example;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

// con esta etiqueta podemos indicarle a JsonB el orden que queramos en los parámetros de los objetos
@JsonbPropertyOrder({"materia", "fecha", "participantes"})
public class Examen implements Serializable {
    private String materia;
    private LocalDateTime fecha;
    private List<String> participantes;

    public Examen(){

    }

    public Examen(String materia, LocalDateTime fecha, List<String> participantes) {
        this.materia = materia;
        this.fecha = fecha;
        this.participantes = participantes;
    }

    public String getMateria() {
        return materia;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public List<String> getParticipantes() {
        return participantes;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(materia).append(System.lineSeparator());
        sb.append(fecha).append(System.lineSeparator());
        for (String s: participantes) {
            sb.append(s).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
