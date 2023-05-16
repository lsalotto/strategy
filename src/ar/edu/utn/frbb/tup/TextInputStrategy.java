package ar.edu.utn.frbb.tup;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextInputStrategy extends BaseInputStrategy{
    private static TextInputStrategy INSTANCE;

    private TextInputStrategy() {
    }

    public static TextInputStrategy getInstance(){
        if (INSTANCE == null) {
            INSTANCE = new TextInputStrategy();
        }
        return INSTANCE;
    }


    @Override
    protected InputReadResult doRead(Scanner scanner) {
        return new InputReadResult().setReadResult(Boolean.TRUE).setInputeadRead(scanner.nextLine());
    }

    @Override
    public boolean isValidInput(Object input) {
        return false;
    }
}
