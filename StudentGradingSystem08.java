public class StudentGradingSystem08 {

    static class InvalidMarksException extends Exception {
        InvalidMarksException(String message) {
            super(message);
        }
    }

    static class Student {
        String name;
        int marks;

        Student(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }

        void assignGrade() throws InvalidMarksException {
            if (marks < 0 || marks > 100) {
                throw new InvalidMarksException("Marks must be between 0 and 100");
            }

            if (marks >= 90)
                System.out.println("Grade: A");
            else if (marks >= 75)
                System.out.println("Grade: B");
            else if (marks >= 50)
                System.out.println("Grade: C");
            else
                System.out.println("Grade: Fail");
        }
    }

    public static void main(String[] args) {
        Student s = new Student("Prayash", 85);

        try {
            s.assignGrade();
        } catch (InvalidMarksException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}