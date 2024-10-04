import java.util.Scanner;
public class JavaProblemSet19 {

    public static class InvalidInputException extends Exception {
        public InvalidInputException(String message) {
            super(message);
        }
    }


    public static void validateInput(int value) throws InvalidInputException {
        if (value < 0 || value > 100) {
            throw new InvalidInputException("Input value must be between 0 and 100.");
        }
        System.out.println("Input value is valid: " + value);
    }

    public static void main(String[] args) {
        try {
            System.out.print("Enter a value between 0 and 100: ");
            Scanner scanner = new java.util.Scanner(System.in);
            int value = scanner.nextInt();
            validateInput(value);
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
