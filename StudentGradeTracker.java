import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("=== Student Grade Tracker ===");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i+1) + ": ");
            String name = sc.nextLine();

            System.out.print("Enter grade for " + name + ": ");
            double grade = sc.nextDouble();
            sc.nextLine(); 

            students.add(new Student(name, grade));
        }

        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            double g = s.getGrade();
            total += g;

            if (g > highest) {
                highest = g;
                topStudent = s.getName();
            }
            if (g < lowest) {
                lowest = g;
                lowStudent = s.getName();
            }
        }

        double average = total / students.size();

        System.out.println("\n=== Summary Report ===");
        for (Student s : students) {
            System.out.println(s.getName() + " - " + s.getGrade());
        }

        System.out.println("\nClass Average: " + average);
        System.out.println("Highest Score: " + highest + " (by " + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (by " + lowStudent + ")");
    }
}
