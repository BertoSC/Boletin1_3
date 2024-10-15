package org.example.EjercicioDaoJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ClasificacionJSONDAO implements Dao <Clasificacion, String> {

    public static final Path DEFAULT_PATH = Paths.get("e:\\data\\");
    public static final Gson gson = new Gson();

    @Override
    public Clasificacion get(String id) {
        return null;
    }

    @Override
    public List<Clasificacion> getAll() {
        List<Clasificacion> listaC;
        Clasificacion temp;
        try (var in = Files.newBufferedReader(DEFAULT_PATH)){


        } catch (IOException e){
            System.out.println("Error en la operación");
        }
        return List.of();
    }

    @Override
    public boolean save(Clasificacion obxecto) {
        try {
            gson.toJson(obxecto, Files.newBufferedWriter(DEFAULT_PATH));
            return true;
        } catch (IOException e) {
            System.out.println("Error en la operación de guardado");
            return false;
        }

    }

    @Override
    public boolean delete(Clasificacion obx) {
      return false;
    }

    @Override
    public boolean deleteAll() {
        try{
            Files.deleteIfExists(DEFAULT_PATH);
            Files.createFile(DEFAULT_PATH);
            return true;
        } catch (IOException e) {
            System.out.println("Error en la operación de borrado");
            return false;
        }
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public void update(Clasificacion obx) {

    }
}
