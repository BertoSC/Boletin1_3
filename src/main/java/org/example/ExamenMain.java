package org.example;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

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

        //se crea el objeto Examen inicial
        Examen ad = new Examen("Acceso a Datos", fechaHora, nombres);

        // con esta clase aplicamos formato al JSON, para especificar si los datos serializados se formatean o no con saltos de línea y sangría
        JsonbConfig config = new JsonbConfig().withFormatting(true);

        // para aplicar la congiguración tenemos que usar newBuilder(), no create(), y aplicar la config con withConfig(instancia config) y build()
        Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();

        //usamos toJson para iniciar la serialización del objeto, devuelve un String
        String strJson = jsonb.toJson(ad);

        //se crea un Path para indicar el archivo que recibirá los datos del objeto
        Path p = Path.of("accesoADatos.json");

        //se utiliza un buffer para optimizar la escritura del string JSon en la ruta indicada
        try (var f = Files.newBufferedWriter(p)) {
            f.write(strJson);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //se imprime el JSON por pantalla directamente desde al archivo
        String line;
        System.out.println("Objeto examen pasado a JSON con JSON-B:");

        try (var rF = Files.newBufferedReader(p)) {
            while ((line = rF.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        String jsonArch;
        //se inicia el proceso contrario: se accede al archivo para recuperar el String JSON
        try {
            jsonArch = Files.readString(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //se usa fromJson para deserializar el Examen inicial y crear un nuevo Examen con los datos del archivo
        Examen otroEx = jsonb.fromJson(jsonArch, Examen.class);

        //se imprime por pantalla el nuevo objeto construido
        System.out.println("Nuevo objeto Examen construido con la info del archivo JSON: ");
        System.out.println(otroEx);


    }
}
