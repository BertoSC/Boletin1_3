package org.example;

import java.io.FileReader;
import java.io.IOException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import static java.lang.System.*;

public class RunJSScript {
    public static void main(String[] args) {

        // este código permite usar archivos de JavaScript y ejecutarlos mediante Java

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("ECMAScript");

        // con el método eval convertimos la expresión del archivo JavaScript "prueba.js" en una cadena de código ejecutable
        try {
            engine.eval(new FileReader("C:\\Users\\a23albertogc\\Desktop\\AD\\Boletin1_3\\src\\main\\java\\org\\example\\prueba.js"));
        } catch (ScriptException se) {
            err.println(se.getMessage());
        } catch (IOException ioe) {
            err.println(ioe.getMessage());
        }
    }
}