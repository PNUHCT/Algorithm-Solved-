import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no2440 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0) {
            String star = "*".repeat(T+1);
            bw.write(star+"\n");
        }

        bw.close();
    }
}

