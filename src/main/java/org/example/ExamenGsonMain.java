package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ExamenGsonMain {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Terry Bogard");
        nombres.add("Joe Higashi");
        nombres.add("Andy Bogard");
        nombres.add("Mai Shiranui");
        nombres.add("Geese Howard");
        GregorianCalendar greg = new GregorianCalendar(2023, GregorianCalendar.NOVEMBER, 12, 9,45);
        ExamenGson ex = new ExamenGson("Acceso a Datos", greg.getTime(), nombres);

        Gson gb = new GsonBuilder().setPrettyPrinting().create();
        String s = gb.toJson(ex, ExamenGson.class);
        System.out.println(s);
        Path p = Path.of("AccesoADatosGson.Json");
        try (var wr = Files.newBufferedWriter(p)){
            wr.write(s);

        } catch (IOException e){
            System.out.println("Ui");
        }


    }
}
