package ar.edu.utn.frbb.tup;

import java.util.Map;
import java.util.Scanner;

public abstract class BaseInputStrategy implements InputStrategy {

    protected abstract InputReadResult doRead(Scanner scanner);

    @Override
    public Object acceptInput(Scanner scanner) {
        InputReadResult input = doRead(scanner);
        while (!input.getReadResult()) {
            input = doRead(scanner);
        }
        return input.getInputeadRead();
    }

    @Override
    public boolean isValidInput(Object input) {
        return true;
    }


    public static InputStrategy getStrategy(String inputType) {
        if ("String".equals(inputType)) {
            return TextInputStrategy.getInstance();
        } else if ("int".equals(inputType)){
            return NumberInputStrategy.getInstance();
        }
        return TextInputStrategy.getInstance();
    }

    public class InputReadResult {
        private Boolean readResult;
        private Object inputeadRead;

        public Boolean getReadResult() {
            return readResult;
        }

        public InputReadResult setReadResult(Boolean readResult) {
            this.readResult = readResult;
            return this;
        }

        public Object getInputeadRead() {
            return inputeadRead;
        }

        public InputReadResult setInputeadRead(Object inputeadRead) {
            this.inputeadRead = inputeadRead;
            return this;
        }
    }
}
