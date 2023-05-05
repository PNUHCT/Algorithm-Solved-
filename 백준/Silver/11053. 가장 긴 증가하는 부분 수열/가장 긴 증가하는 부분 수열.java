import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        int[] dp = new int[n]; // 수열을 담는게 아니라, 각 위치별로 도달하며 수열에 넣을 수 있는 최대 갯수를 카운트하는 배열
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {  // 구할 부분수열의 길이를 나타냄으로써, 최소 길이를 2 이상으로 확인하기 위해 1부터 시작.
            for (int j = 0; j < i; j++) { // 맨 앞부터 순차적으로 2개씩 비교하기위해 0부터 시작, 구하고자 하는 부분수열의 길이만큼 반복
                if (A[j] < A[i]) { // 앞의 숫자보다 뒤의 숫자가 더 클 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 현재 도달한 위치의 카운트는, 현재 위치의 카운트와 직전 숫자까지 도달한 카운트+1중 더 높은 숫자로 업데이트
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) maxLength = Math.max(maxLength, dp[i]);

        System.out.println(maxLength);
    }
}