public class JavaProblemSet6 {
    public static class Person {
        private String name;
        private int age;
        private String gender;

        public Person() {
            this.name = "";
            this.age = 0;
            this.gender = "";
        }

        public Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public void printDetails() {
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Gender: " + this.gender);
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "Ram";
        person1.age = 30;
        person1.gender = "Male";

        Person person2 = new Person("Lily", 25, "Female");

        System.out.println("Person 1 Details:");
        person1.printDetails();

        System.out.println("\nPerson 2 Details:");
        person2.printDetails();
    }
}