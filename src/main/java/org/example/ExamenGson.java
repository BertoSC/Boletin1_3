package org.example;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import jakarta.json.bind.annotation.JsonbPropertyOrder;

// con esta etiqueta podemos indicarle a JsonB el orden que queramos en los parámetros de los objetos
@JsonbPropertyOrder({"materia", "fecha", "participantes"})
public class ExamenGson {

        private String materia;
        private Date fecha;
        private List<String> participantes;

        // es importante tener constructor por defecto, getters y setters de los datos y toString()
        public ExamenGson(){
        }

        public ExamenGson(String materia, Date fecha, List<String> participantes) {
            this.materia = materia;
            this.fecha = fecha;
            this.participantes = participantes;
        }

        public String getMateria() {
            return materia;
        }

        public Date getFecha() {
            return fecha;
        }

        public List<String> getParticipantes() {
            return participantes;
        }

        public void setMateria(String materia) {
            this.materia = materia;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public void setParticipantes(List<String> participantes) {
            this.participantes = participantes;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Examen de "+materia).append(System.lineSeparator());
            sb.append(fecha).append(System.lineSeparator());
            sb.append("Lista de participantes:").append(System.lineSeparator());
            for (String s: participantes) {
                sb.append(s).append(System.lineSeparator());
            }
            return sb.toString();
        }
    }


