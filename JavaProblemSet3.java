import java.util.HashSet;
import java.util.Set;

public class JavaProblemSet3 {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("apple");
        set.add("banana");
        set.add("cherry");
        set.add("date");
        set.add("elderberry");

        System.out.println("Original Set:");
        printSet(set);

        String[] array = convertSetToArray(set);
        System.out.println("Set converted to Array:");
        JavaProblemSet2.printArray(array);
    }

    public static void printSet(Set<String> set) {
        for (String str : set) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static String[] convertSetToArray(Set<String> set) {
        String[] array = new String[set.size()];
        int i = 0;
        for (String str : set) {
            array[i++] = str;
        }
        return array;
    }
    
}
