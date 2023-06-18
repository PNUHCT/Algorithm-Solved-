import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        while (N-->0) {
            int now = Integer.parseInt(br.readLine());
            for (int i = 0; i < now; i++) bw.append("=");
            bw.write("\n");
        }
        bw.close();
    }
}