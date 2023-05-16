package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.model.Alumno;

import java.util.Map;
import java.util.Scanner;

public class AlumnoInputProcessor {
    private Scanner scanner = new Scanner(System.in);

    public void processInput(Alumno inputObject) {
        Map<String, String> fields = AttributeInspector.getAttributeInputStrategy(Alumno.class);

        for (Map.Entry<String, String> entry:
                fields.entrySet()) {
            String tipoDeDatoALeer = entry.getValue();

            InputStrategy inputStrategy = BaseInputStrategy.getStrategy(tipoDeDatoALeer);

            Object consoleInput = inputStrategy.acceptInput(scanner);

            AttributeInspector.invokeSetter(inputObject, entry.getKey(), consoleInput);
        }
    }



}
