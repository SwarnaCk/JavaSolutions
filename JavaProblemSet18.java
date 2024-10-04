import java.util.Scanner;

public class JavaProblemSet18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();
            
            int[] array = new int[size];
            
            System.out.println("Enter " + size + " elements of the array:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter the index you want to access: ");
            int index = scanner.nextInt();
            
            System.out.println("Value at index " + index + ": " + array[index]);
            
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            System.out.println("Exception occurred: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        
        scanner.close();
    }
}

