import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //читаем строки
        String s1 = scanner.next(); 
        String s2 = scanner.next();
        
        //длины
        int len1 = s1.length(); // N
        int len2 = s2.length(); // M
        
        //создаём таблицу 
        //размер (len1 + 1) на (len2 + 1), чтобы были пустые строка/столбец
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        //заполняем таблицу
        // i идёт по первой строке (с 1 до len1)
        for (int i = 1; i <= len1; i++) {
            // j идёт по второй строке (с 1 до len2)
            for (int j = 1; j <= len2; j++) {
                
                //смотрим на текущие буквы (i-1 и j-1, потому что индексы в строках с 0)
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //если буквы совпали: берём значение из диагонали +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //если буквы НЕ совпали:берём максимум из верхней и левой клетки
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        //ответ в правом нижнем углу
        System.out.println(dp[len1][len2]);
        
        scanner.close();
    }
}