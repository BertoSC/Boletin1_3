package org.example;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExamenMain {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Luz Pozo");
        nombres.add("Xela Arias");
        nombres.add("Alejandra Pizarnik");
        nombres.add("Doris Lessing");
        nombres.add("Susana March");

        LocalDateTime fechaHora = LocalDateTime.of(2023, 11, 12, 9, 45);

        Examen ad= new Examen("Acceso a Datos", fechaHora, nombres);

        Jsonb jsonb = JsonbBuilder.create();

        String strJson = jsonb.toJson(ad);

        Path p = Path.of("accesoADatos.json");

        if (!Files.exists(p)){
            try (var f =Files.newBufferedWriter(p)){
                f.write(strJson);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        String line;
        System.out.println("Objeto examen pasado a JSON con JSON-B:");

        try(var rF= Files.newBufferedReader(p)){
            while ((line= rF.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();

        try {
            String jsonArch = Files.readString(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Examen otroEx = jsonb.fromJson(strJson, Examen.class);
        System.out.println("Nuevo objeto Examen construido con la info del archivo JSON: ");
        System.out.println(otroEx);



    }
}
