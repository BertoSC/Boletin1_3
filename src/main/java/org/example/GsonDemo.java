package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import static java.lang.System.*;

public class GsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();

        // Deserialization de una cadena
        String nome = gson.fromJson("\"Sylvia Plath\"", String.class);
        out.println(nome); // imprime sin las comillas
        out.println(gson.toJson(nome)); // respeta las comillas

        // Serializacion de un entero
        gson.toJson(256, out); // por pantalla
        out.println(); // salto de línea.

        // Serialización
        gson.toJson("<html>", out); // por pantalla.
        out.println(); // salto de línea  --> no pilla el <> de html

        // Gson personalizado deshabilitando el escapado de HTML
        gson = new GsonBuilder().disableHtmlEscaping().create();
        gson.toJson("<html>", out); // Sin escapar HTML --> pilla <> de html
        out.println();
    }
}