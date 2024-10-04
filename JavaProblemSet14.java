public class JavaProblemSet14 {
    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.setName("Swarna Roy");
        employee.setAge(15); 
        employee.setSalary(-1000); 
        employee.setAge(25); 
        employee.setSalary(5000); 

        System.out.println("Name: " + employee.getName());
        System.out.println("Age: " + employee.getAge());
        System.out.println("Salary: " + employee.getSalary());
    }

}

class Employee {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be greater than 18.");
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary must be non-negative.");
        }
    }
}
