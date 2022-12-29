import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 9; i++) {
            System.out.println(String.format("%d * %d = %d", a, i, a*i));
        }

    }
}