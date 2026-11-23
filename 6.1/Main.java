import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //читаем массив
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        //читаем запросы
        int m = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < m; i++) {
            long query = scanner.nextLong();
            long closest = findClosest(arr, query);
            
            //добавляем результат к строке (чтобы не тормозить программу на System.out.println)
            result.append(closest);
            if (i < m - 1) {
                result.append(" ");
            }
        }

        //выводим весь ответ сразу
        System.out.println(result.toString());
        scanner.close();
    }

    private static long findClosest(long[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        //проверка выхода за границы
        if (left == arr.length) return arr[arr.length - 1];
        if (right < 0) return arr[0];

        long diffLeft = target - arr[right];
        long diffRight = arr[left] - target;

        if (diffLeft <= diffRight) {
            return arr[right];
        } else {
            return arr[left];
        }
    }
}