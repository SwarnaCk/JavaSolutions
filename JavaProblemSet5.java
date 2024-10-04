import java.util.HashMap;
import java.util.Map;

public class JavaProblemSet5 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(4, "Four");

        System.out.println("Keys in the Map:");
        printKeys(map);

        boolean result = containsKey(map, 3);
        System.out.println("Map contains key 3: " + result);
    }

    public static void printKeys(Map<Integer, String> map) {
        for (Integer key : map.keySet()) {
            System.out.print(key + " ");
        }
        System.out.println();
    }

    public static boolean containsKey(Map<Integer, String> map, int key) {
        return map.containsKey(key);
    }
    
}
