import java.io.*;
import java.util.StringTokenizer;

public class no13172 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int MOD = 1000000007;
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int M = Integer.parseInt(br.readLine());
        long N = 1, S = 0;
        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            S = s * N + S * n;
            N = N * n;
            S %= MOD;
            N %= MOD;
        }

        if(S % N != 0) bw.write((search(N, MOD-2) * S) % MOD + "");
        else bw.write(S/N + "");

        bw.flush();
        bw.close();
    }

    private static long search(long N, int idx) {
        if(idx == 1) return N;

        long temp = search(N, idx/2);
        if(idx % 2 == 1) return temp * temp % MOD * N % MOD;
        else return temp * temp % MOD;
    }
}
