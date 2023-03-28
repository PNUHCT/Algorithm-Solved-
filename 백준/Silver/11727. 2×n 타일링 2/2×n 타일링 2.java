import java.io.*;

public class Main {
    /**
     * DP 문제
     * N번째 타일의 경우의 수 = (N-1번째 타일의 경우의 수) + (N-2번째 타일의 경우의 수 * 2)
     * 10007을 넘으면 나눠주기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10007];
        arr[1] = 1;
        arr[2] = 3;

        if(N>2) {
            for (int i = 3; i <= N; i++) arr[i] = (arr[i - 1] + (arr[i - 2] * 2))%10007;
        }
        System.out.println(arr[N]);
    }
}