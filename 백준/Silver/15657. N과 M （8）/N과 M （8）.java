import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

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
        StringTokenizer numbers = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<N ; i++) nums[i] = Integer.parseInt(numbers.nextToken());
        Arrays.sort(nums);
        Combination(0,0);

        bw.close();
    }
    private static void Combination(int cnt, int k) throws IOException{
        if(cnt == M) {
            for(int i=0 ; i<M ; i++) bw.append(""+subset[i]+" ");
            bw.append("\n");
            return;
        }
        for(int i=k ; i<N ; i++) {
            subset[cnt] = nums[i];
            Combination(cnt+1, i);
        }
    }
}