import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 첫 줄에 N과 M이 주어진다.
 * 두 번째 줄에 N개의 숫자가 공백으로 구분되어 주어진다.
 * N개의 숫자 중 M개를 뽑는 경우의 수를 중복을 허용하여 구하기
 */

public class no15657 {
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