import org.json.JSONObject;
import org.json.JSONException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaProblemSet8{

    private static final String FILE_PATH = "data.json";

    public static void main(String[] args) {
        JavaProblemSet8 reader = new JavaProblemSet8();
        JSONObject jsonObject = reader.readJSONFile();
        reader.printJSONValues(jsonObject);
    }

    public JSONObject readJSONFile() {
        try {
            String content = new String(Files.readAllBytes(Paths.get(FILE_PATH)));
            return new JSONObject(content);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        } catch (JSONException e) {
            System.out.println("Error parsing JSON: " + e.getMessage());
            return null;
        }
    }

    public void printJSONValues(JSONObject jsonObject) {
        if (jsonObject != null) {
            try {
                System.out.println("Name: " + jsonObject.getString("name"));
                System.out.println("Age: " + jsonObject.getInt("age"));
                System.out.println("Email: " + jsonObject.getString("email"));
            } catch (JSONException e) {
                System.out.println("Error retrieving values: " + e.getMessage());
            }
        }
    }
}