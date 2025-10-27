import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    void display() {
        System.out.println("ID: " + id + " | Name: " + name + " | Age: " + age + " | Course: " + course);
    }
}

public class StudentManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> searchStudent();
                case 4 -> deleteStudent();
                case 5 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, age, course));
        System.out.println("✅ Student added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter student ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        for (Student s : students) {
            if (s.id == id) {
                s.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Student not found!");
    }

    static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.id == id);
        if (removed)
            System.out.println("🗑️ Student deleted successfully!");
        else
            System.out.println("Student not found!");
    }
}
