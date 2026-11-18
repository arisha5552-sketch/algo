import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMapImpl<String> map = new HashMapImpl<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "put":
                    map.put(parts[1], parts[2]);
                    break;
                case "delete":
                    map.delete(parts[1]);
                    break;
                case "get":
                    System.out.println(map.getValue(parts[1]));
                    break;
                default:
                    // некорректных команд нет
            }
        }
        scanner.close();
    }
}