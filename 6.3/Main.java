import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //читаем число a, может быть до 10^10, используем double.
        double a = scanner.nextDouble();
        
        //задаем границы поиска
        double left = 0.0;
        //правая берется с запасом, при a >= 1 корень точно меньше a + 1.
        double right = Math.max(1.0, a); 
        
        //бинарный поиск (100 итераций стандарт для высокой точности)
        for (int i = 0; i < 100; i++) {
            double mid = (left + right) / 2.0;
            
            double f_mid = mid * mid - mid + Math.sqrt(mid);
            
            if (f_mid < a) {
                //x слишком маленький, ищем правее
                left = mid;
            } else {
                //больше или равно нужному, x слишком большой, ищем левее
                right = mid;
            }
        }
        
        System.out.printf("%.10f\n", left);
        
        scanner.close();
    }
}