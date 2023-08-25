import java.io.*;
import java.util.StringTokenizer;

public class no11054 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int[] arr;
    private static Integer[] Rt_DP, Lt_DP;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Rt_DP = new Integer[N];
        Lt_DP = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        /**
         * 1. arr에 대해, 0번 인덱스~N-1번 인덱스까지 도달하면서 오름차순으로 가장 길게 얻을 수 있는 길이를 기록하는 DP를 실행
         * 2. 반대 방향으로 DP실행
         * 3. 두 수열의 값을 합치면 바이토닉 수열의 최대값들이 기록된 DP 배열이 됨.
         * 4. 단, 각 위치별 중복값을 포함하게 되므로, 각 위치 최대값에 대해 -1을 해줘야 함
         */

        for(int i=0 ; i<N ; i++) {
            LIS(i);
            LDS(i);
        }

        int max = -1;
        for(int i = 0; i <N ; i++) max =Math.max(Rt_DP[i]+ Lt_DP[i], max);

        System.out.println(max - 1); // 결국 모든 값은 다 -1 해줘야 하므로
    }

    // 순방향 오름차순 부분 수열 구하기
    private static int LIS(int N) {

        // 탐색하지 않았던 곳이면 1로 초기화
        if (Rt_DP[N] == null) {
            Rt_DP[N] = 1;

            // 이전 노드 탐색
            for (int i=N-1; i>=0; i--) {
                //이전 노드 중 작은 값을 발견한 경우
                if(arr[i] < arr[N]) Rt_DP[N] = Math.max(Rt_DP[N], LIS(i)+1);
            }
        }
        return Rt_DP[N];
    }

    // 역방향 오름차순 부분 수열 구하기
    private static int LDS(int N) {

        // 탐색하지 않았던 곳이면 1로 초기화
        if (Lt_DP[N] == null) {
            Lt_DP[N] = 1;

            // N 이후 노드 탐색
            for (int i = N + 1; i < Lt_DP.length; i++) {
                //이후 노드 중 작은 값을 발견한 경우
                if(arr[i] < arr[N]) Lt_DP[N] = Math.max(Lt_DP[N], LIS(i) +1);
            }
        }
        return Lt_DP[N];
    }
}

