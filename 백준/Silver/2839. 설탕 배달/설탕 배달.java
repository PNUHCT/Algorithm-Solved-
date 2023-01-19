import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = -1;
        for (int i = N / 5; i >= 0; i--) {
            int K = N - (5 * i);
            if (K % 3 == 0) {
                count += i + (K / 3) + 1;
                break;
            }
        }
        System.out.println(count);
    }
}