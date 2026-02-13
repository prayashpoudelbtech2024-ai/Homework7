import java.util.ArrayList;

class Student {
    String name;
    ArrayList<Double> grades = new ArrayList<Double>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(double grade) {
        grades.add(grade);
    }

    double calculateAverage() {
        double sum = 0;

        for (double g : grades) {
            sum = sum + g;
        }

        if (grades.size() == 0) {
            return 0;
        }

        return sum / grades.size();
    }

    void displayStudentDetails() {
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
        System.out.println("------------------");
    }
}

class GradeManager {
    ArrayList<Student> students = new ArrayList<Student>();

    void addStudent(Student student) {
        students.add(student);
    }

    Student findStudentByName(String name) {
        for (Student s : students) {
            if (s.name.equals(name)) {
                return s;
            }
        }
        return null;
    }

    void displayAllStudents() {
        System.out.println("\nAll Students:");
        for (Student s : students) {
            s.displayStudentDetails();
        }
    }
}

public class Main2 {
    public static void main(String[] args) {

        GradeManager gm = new GradeManager();

        Student s1 = new Student("Prayash");
        Student s2 = new Student("Ram");

        s1.addGrade(80);
        s1.addGrade(90);

        s2.addGrade(70);
        s2.addGrade(60);

        gm.addStudent(s1);
        gm.addStudent(s2);

        Student found = gm.findStudentByName("Prayash");

        if (found != null) {
            System.out.println("\nStudent Found:");
            found.displayStudentDetails();
        }

        gm.displayAllStudents();
    }
}
