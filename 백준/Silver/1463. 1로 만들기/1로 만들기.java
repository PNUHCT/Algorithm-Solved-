import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        // Integer배열인 이유는 길이 설정시, 모든 자리에 null로 채워지기 때문. X+1사이즈를 해야 인덱스에 맞게 들어간다.
        dp = new Integer[X+1];
        // 0 또는 1일경우, null이 아니어야 재귀반복이 종료된다. 초기화 시켜놓지 않으면, -1까지 가서 OutOfIndex 발생
        dp[0] = dp[1] = 0;
        
        System.out.println(recur(X));

    }

    private static int recur (int X) {
        // 0 또는 1에서 0을 만나기 전까지 재귀 반복함
        if(dp[X]==null) {
            
            // 6으로 나눠지는 경우
            // 3으로 나눈 경우와 2로 나눈 경우 중 최소값 => 앞에서 구한 최소값과 -1했을 때의 최소값 중 최소값 => 최종 결과에 +1 한 값
            if(X%6==0) dp[X] = Math.min(recur(X-1) , Math.min(recur(X/3) , recur(X/2) )) + 1;

            // 3으로만 나눠지는 경우
            else if (X%3==0) dp[X] = Math.min(recur(X/3), recur(X-1)) + 1;

            // 2로만 나눠지는 경우
            else if (X%2==0) dp[X] = Math.min(recur(X/2), recur(X-1)) + 1;

            // 2와 3 모두 안되는 경우
            else dp[X] =recur(X-1) + 1;
        }
        
        return dp[X];
    }
}

