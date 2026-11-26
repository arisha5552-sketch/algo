import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        long[] pref = new long[n];
        long current = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            long val = Long.parseLong(st.nextToken());
            current += val;
            pref[i] = current;
        }
        
        st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        
        PrintWriter out = new PrintWriter(System.out);
        for (int q = 0; q < k; q++) {
            st = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            long sum;
            if (i == 0) {
                sum = pref[j];
            } else {
                sum = pref[j] - pref[i - 1];
            }
            out.print(sum);
            out.print('\n');
        }
        out.flush();
        reader.close();
    }
}