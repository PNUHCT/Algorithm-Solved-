import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class no11727 {
    /**
     * DP 문제
     * N번째 타일의 경우의 수 = (N-1번째 타일의 경우의 수) + (N-2번째 타일의 경우의 수 * 2)
     * 10007을 넘으면 나눠주기
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 3;

        // 3번째 부터 시작
        if(N>2) for (int i = 3; i <= N; i++) arr[i] = (arr[i - 1] + (arr[i - 2] * 2))%10007;  // DP 계산
        System.out.println(arr[N]);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int N = Integer.parseInt(br.readLine());
//
//        List<Integer> list = new ArrayList<>();
//        list.add(1); // 0번째는 1가지
//        list.add(1); // 1번째는 1가지
//
//        for (int i = 2; i <= N; i++) list.add((list.get(i - 1) + (list.get(i - 2) * 2)) % 10007); // DP 계산
//
//        System.out.println(list.get(N)); // 출력
//    }
}

