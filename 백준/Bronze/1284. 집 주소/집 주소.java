import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String T;

    public static void main(String[] args) throws IOException {

        while (true) {
            T= br.readLine();
            
            if(T.equals("0")) break; // 베이스 코드

            String[] arr = T.split("");

            int sum = 1; // 첫 공백 포함
            for(String s : arr) {
                if(s.equals("1")) sum += 3;  // 2 + 1
                else if(s.equals("0")) sum += 5;  // 4 + 1
                else sum += 4;  // 3 + 1
            }
            bw.write(sum+"\n");
        }
        
        bw.close();
    }
}