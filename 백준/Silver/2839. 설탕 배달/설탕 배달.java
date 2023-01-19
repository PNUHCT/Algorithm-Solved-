import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = N / 5; i >= 0; i--) {
            int K = N - (5 * i);
            if (K % 3 == 0) {
                count = 0;
                count += i + (K / 3);
                break;
            }
            if (i == N / 5 && K%3<3 ) {
                count = -1;
            }
        }

        System.out.println(count);
    }
}