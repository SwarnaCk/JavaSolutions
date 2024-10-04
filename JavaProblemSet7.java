public class JavaProblemSet7 {
    public static class MathUtility {
        public static final double PI = 3.14159;

        public static double calculateCircleArea(double radius) {
            return PI * radius * radius;
        }
    }

    public static void main(String[] args) {
        System.out.println("Value of PI: " + MathUtility.PI);

        double radius = 5;
        double area = MathUtility.calculateCircleArea(radius);
        System.out.println("Area of circle with radius " + radius + ": " + area);
    }
}
