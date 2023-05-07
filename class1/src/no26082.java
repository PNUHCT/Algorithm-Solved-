import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no26082 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        System.out.println(3 * (B/A) * C);
    }
}

