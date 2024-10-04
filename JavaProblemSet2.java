import java.util.ArrayList;
import java.util.List;

class JavaProblemSet2{
    public static void main(String []args){
        String[] array = {"abc", "xyz", "def", "aeiou", "pqr", "abc"};
        System.out.println("Original Array:");
        printArray(array);

        List<Object> list = convertArrayToList(array);

        System.out.println("Array converted to List:");
        JavaProblemSet1.printList(list);

        String[] resultArray = removeItemFromArray(array, "abc");
        System.out.println("Array after removing 'abc':");
        printArray(resultArray);

    }

    public static void printArray(String[] array) {
        for (String str : array) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static List<Object> convertArrayToList(String[] array) {
        List<String> list = new ArrayList<>();
        for (String str : array) {
            list.add(str);
        }
        return new ArrayList<>(list);
    }

    public static String[] removeItemFromArray(String[] array, String itemToRemove) {
        ArrayList<String> result = new ArrayList<>();
        for (String item : array) {
            if (!item.equals(itemToRemove)) {
                result.add(item);
            }
        }
        return result.toArray(new String[0]);
    }
};