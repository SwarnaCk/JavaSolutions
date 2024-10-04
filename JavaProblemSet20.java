import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class Student {
    private int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

public class JavaProblemSet20 {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        students.add(new Student(101, "Riya", 95.6));
        students.add(new Student(102, "Bharat", 88.3));
        students.add(new Student(103, "Lily", 92.1));

        try {
            saveTopStudentToProperties();
        } catch (IOException e) {
            System.out.println("Error writing to properties file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Error: List is empty or student fields are null");
        }
    }

    private static void saveTopStudentToProperties() throws IOException, NullPointerException {
        if (students.isEmpty()) {
            throw new NullPointerException("Student list is empty");
        }

        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.getGrade() > topStudent.getGrade()) {
                topStudent = student;
            }
        }

        Properties props = new Properties();
        props.setProperty("id", String.valueOf(topStudent.getId()));
        props.setProperty("name", topStudent.getName());
        props.setProperty("grade", String.valueOf(topStudent.getGrade()));

        try (FileOutputStream out = new FileOutputStream("top_student.properties")) {
            props.store(out, "Top Student Information");
        }

        System.out.printf("Top student details saved successfully: ID: %d Name: %s Grade: %.1f\n",
                topStudent.getId(), topStudent.getName(), topStudent.getGrade());
    }
}
