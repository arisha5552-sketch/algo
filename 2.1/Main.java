import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner - это стандартный способ чтения ввода в Java (аналог cin)
        Scanner scanner = new Scanner(System.in);
        
        // читаем число N
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            
            // Создаем список (аналог vector в C++)
            List<Integer> nums = new ArrayList<>();
            
            // читаем N чисел и добавляем их в список
            for (int i = 0; i < n; i++) {
                nums.add(scanner.nextInt());
            }
            
            // создаем объект сортировки и вызываем метод
            InsertionSort sorter = new InsertionSort();
            sorter.sort(nums);
            
            // выводим
            for (int i = 0; i < n; i++) {
                System.out.print(nums.get(i));
                if (i < n - 1) { // Пробел после каждого числа, кроме последнего
                    System.out.print(" ");
                }
            }
        }
        
        scanner.close(); // закрываем сканер
    }
}