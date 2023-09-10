import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, N;
    private static BigInteger Sum;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(br.readLine());

        while(T-->0) {
            br.readLine(); // 빈칸
            Sum = new BigInteger("0");

            N = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++) Sum = Sum.add(new BigInteger(br.readLine()));
            String result = Sum.remainder(new BigInteger(String.valueOf(N))).compareTo(new BigInteger("0")) == 0 ? "YES" : "NO";

            bw.write(result+"\n");
        }

        bw.close();
    }
}