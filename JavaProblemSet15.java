public class JavaProblemSet15 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();

        rectangle.setLength(5.0);
        rectangle.setWidth(3.0);

        System.out.println("Area: " + rectangle.getArea());
    }

}

class Rectangle {
    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getArea() {
        return length * width;
    }
}
