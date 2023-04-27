import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[] nums;
    private static int[] subset;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        subset = new int[M];
        for(int i=1 ; i<=N ; i++) nums[i-1] = i;

        Combination(0, 0);

        bw.close();
    }

    private static void Combination (int cnt, int k) throws IOException {
        if(cnt == M) {
            for(int i = 0 ; i<M ; i++) bw.append(""+subset[i]+" ");
            bw.append("\n");
            return;
        }

        for(int i = k; i<N ; i++) {
            subset[cnt] = nums[i];
            Combination(cnt+1, i);
        }
    }
}