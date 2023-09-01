import java.io.*;
import java.util.*;

public class no2455 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int max = 0;
        int total = 0;
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            total -= A;
            total += B;
            max = Math.max(max, total);

            if(B==0) break;
        }
        System.out.println(max);
    }
}

