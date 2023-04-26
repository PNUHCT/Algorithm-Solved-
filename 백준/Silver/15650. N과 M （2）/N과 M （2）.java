import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 1부터 N까지의 숫자 중, M개를 고르는 모든 수열의 경우의 수를 구하기
     * 단, 오름차순 정렬
     * 단, N과 M은 1이상 8이하
     */
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
        for(int i=1; i<=N ; i++) nums[i-1] = i;

        Combination(0, 0);

        bw.close();
    }

    private static void Combination (int cnt, int k) throws IOException {
        if (cnt == M) {
            for(int i = 0 ; i< subset.length ; i++) bw.append(""+subset[i]).append(" ");
            bw.append("\n");
            return;
        }

        for(int i = k ; i < nums.length; i++) {
            subset[cnt] = nums[i];
            Combination(cnt + 1, i + 1);
        }
    }
}