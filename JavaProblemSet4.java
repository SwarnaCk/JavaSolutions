public class JavaProblemSet4 {
    public static void main(String[] args) {
        int[] array = {2, 4, 6, 8, 10, 12};

        int[] reversedArray = reverseArray(array);
        System.out.println("Reversed Array:");
        printIntegerArray(reversedArray);

        String[] result = containsValue(array, 10);
        JavaProblemSet2.printArray(result);
    }

    public static void printIntegerArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static int[] reverseArray(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

    public static String[] containsValue(int[] array, int value) {
        for (int num : array) {
            if (num == value) {
                String[] result = new String[array.length];
                for (int i = 0; i < array.length; i++) {
                    result[i] = String.valueOf(array[i]);
                }
                return result;
            }
        }
        return new String[0];
    }
    
}
