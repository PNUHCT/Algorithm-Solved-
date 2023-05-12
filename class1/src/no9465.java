import java.io.*;
import java.util.*;
import java.math.*;

public class no9465 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            int N = Integer.parseInt(br.readLine());
            maxSum(N);        
        }
        bw.close();
    }

    private static void maxSum (int N) throws IOException {
        int[][] map = new int[2][N+1];

        // 입력을 통해 스티커 맵을 완성
        for(int i=0; i<2 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=1 ; j<=N ;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 합산한 값을 기록하여 다음 합산에 참고하기위한 이중배열
        int[][]  dp = new int[2][N+1];

        dp[0][1] = map[0][1];
        dp[1][1] = map[1][1];
        
        // 0번째와 1번째를 비교하는 경우가 있어야 하므로 배열을 N+1 길이로 해야함
        for(int i=2; i<=N ; i++) {
            dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + map[0][i];
            dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + map[1][i];
        }
        bw.write(Math.max(dp[0][N], dp[1][N])+ "\n");
    }
}