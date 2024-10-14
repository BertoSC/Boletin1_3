package org.example;

import com.google.gson.Gson;
import org.glassfish.json.JsonUtil;

import java.time.LocalDateTime;
import java.util.GregorianCalendar;

public class GsonEjemplo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        // si fuesen otros tipo de fecha, como LocalDateTime, daría error porque GSON no sabría serializarlos
        // lo hacen para obligarte a que uses un adatador específico para el tipo de dato
        // como quiero que coja el LocalDateTime y como quiero que lo pase-> revisar la API
        GregorianCalendar g = new GregorianCalendar(2024, GregorianCalendar.OCTOBER, 14, 9, 0);
        Proba proba = new Proba("Pepe", 33, g.getTime());
        String json = gson.toJson(proba);
        System.out.println(json);
    }
}
