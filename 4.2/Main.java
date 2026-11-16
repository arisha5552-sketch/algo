import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueImpl pq = new PriorityQueueImpl();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            String command = parts[0];

            switch (command) {
                case "enqueue":
                    pq.enqueue(Integer.parseInt(parts[1]));
                    break;
                case "dequeue-max":
                    pq.dequeueMax();
                    break;
                case "inc":
                    long op = Long.parseLong(parts[1]);
                    int add = Integer.parseInt(parts[2]);
                    pq.increment(op, add);
                    break;
                default:
                    // некорректных команд нет
            }
        }
        scanner.close();
    }
}