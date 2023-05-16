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

            Object consoleInput = BaseInputStrategy.getStrategy(entry.getValue()).acceptInput(scanner);

            AttributeInspector.invokeSetter(inputObject, entry.getKey(), consoleInput);
        }
    }



}
