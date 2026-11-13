import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(5, 2, 8, 1));
        new GenericInsertionSort<Integer>().sort(ints);
        System.out.println(ints);

        List<String> strs = new ArrayList<>(List.of("banana", "apple", "cherry"));
        new GenericInsertionSort<String>().sort(strs);
        System.out.println(strs);

        List<LocalDateTime> dates = new ArrayList<>(List.of(
            LocalDateTime.of(2024, 5, 1, 12, 0),
            LocalDateTime.of(2024, 1, 1, 10, 0),
            LocalDateTime.of(2024, 3, 1, 8, 0)
        ));
        new GenericInsertionSort<LocalDateTime>().sort(dates);
        System.out.println(dates);

        List<Student> students = new ArrayList<>(List.of(
            new Student("Vasya", 21),
            new Student("Anton", 22),
            new Student("Vasya", 19)
        ));
        new GenericInsertionSort<Student>().sort(students);
        System.out.println(students);

        List<UUID> uuids = new ArrayList<>(List.of(
            UUID.fromString("00000000-0000-0000-0000-000000000002"),
            UUID.fromString("00000000-0000-0000-0000-000000000001")
        ));
        new GenericInsertionSort<UUID>().sort(uuids);
        System.out.println(uuids);
    }
}