import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JavaProblemSet17 {
    public static void main(String[] args) {
        File file = new File("data.txt");
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
