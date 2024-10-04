import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class JavaProblemSet1{
    public static void main(String []args){
        List<Object> integerList = new ArrayList<>();
        integerList.add(123);
        integerList.add(0);
        integerList.add(-5);
        integerList.add(-999);
        integerList.add(2345);
        integerList.add(123);
        integerList.add(-9);
        integerList.add(101);
        
        System.out.println("Original List : ");
        printList(integerList);

        System.out.println("Sorted List : ");
        sortList(integerList);
        printList(integerList);
    }

    public static void printList(List<Object> list) {
        for (Object obj : list) {
            System.out.print(obj + " ");
        }
        System.out.println();
    }

    public static void sortList(List<Object> list) {
    Collections.sort(list, new Comparator<Object>() {
        @Override
        public int compare(Object o1, Object o2) {
            return o1.toString().compareTo(o2.toString());
        }
    });
}
};