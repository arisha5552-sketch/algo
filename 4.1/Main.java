import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MinStackImpl stack = new MinStackImpl();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] parts = line.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "push":
                    stack.push(Integer.parseInt(parts[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                case "min":
                    System.out.println(stack.min());
                    break;
                default:
                    // по условию некорректных команд нет
            }
        }
        scanner.close();
    }
}