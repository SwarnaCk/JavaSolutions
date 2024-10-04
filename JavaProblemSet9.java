import java.io.*;
import java.util.Properties;

public class JavaProblemSet9 {

    private static final String FILE_PATH = "config.properties";

    public static void main(String[] args) {
        JavaProblemSet9 manager = new JavaProblemSet9();
        manager.readAndPrintProperties();
        manager.modifyUsername("newadmin");
    }

    public void readAndPrintProperties() {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(FILE_PATH)) {
            prop.load(input);

            System.out.println("url: " + prop.getProperty("url"));
            System.out.println("username: " + prop.getProperty("username"));
            System.out.println("password: " + prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void modifyUsername(String newUsername) {
        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(FILE_PATH)) {
            prop.load(input);

            prop.setProperty("username", newUsername);

            try (OutputStream output = new FileOutputStream(FILE_PATH)) {
                prop.store(output, null);
                System.out.println("Username updated successfully.");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
