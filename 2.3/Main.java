import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine(); //
            
            List<Student> students = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(" "); //разделяем имя и возраст
                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                students.add(new Student(name, age));
            }

            StudentSort sorter = new StudentSort();
            sorter.sort(students);

            for (Student s : students) {
                System.out.println(s.toString());
            }
        }
        scanner.close();
    }
}