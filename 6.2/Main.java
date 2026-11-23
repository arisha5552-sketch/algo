import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //читаем 
        long n = scanner.nextLong();
        long w = scanner.nextLong();
        long h = scanner.nextLong();
        
        //левая граница — минимально возможный квадрат
        long left = 1;
        //правая граница — с огромным запасом (все дипломы в ряд)
        long right = Math.max(w, h) * n; 
        
        //бинарный поиск
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            //считаем, сколько влезает
            long horizontal = mid / w;
            long vertical = mid / h;
            
            //проверка
            if (horizontal * vertical >= n) {
                //влезает, пробуем уменьшить
                right = mid;
            } else {
                //не влезает, нужно увеличить
                left = mid + 1;
            }
        }
        
        //выводим
        System.out.println(left);
        
        scanner.close();
    }
}