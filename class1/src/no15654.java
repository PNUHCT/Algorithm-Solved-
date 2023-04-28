import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N개의 숫자 중 M개를 선택하는 수열을 모두 구하시오
 * 이때, 같은 수를 두 번 이상 포함하지 않게 해야한다(중복 X)
 * 입력은 첫 줄에 N과 M이 주어지며,
 * 두 번째 줄에는 N개의 숫자가 주어진다.
 */

public class no15654 {

    /**
     * 재귀코드[실패]
     */

    /**
     * recursive 함수는 현재까지 선택한 숫자들을 answer 배열에 저장하고, 방문한 인덱스를 visited 배열을 통해 체크합니다.
     * 재귀 함수의 기저 조건은 현재까지 선택한 숫자의 개수가 M과 같을 때입니다.
     * 이 때 answer 배열에 저장된 숫자를 출력하고, 재귀 호출을 종료합니다.
     * 재귀 함수의 반복문에서는 선택된 인덱스를 기준으로 이후의 인덱스 중에서 다음 숫자를 선택합니다. 이를 위해 start 매개변수를 사용합니다.
     * 선택한 인덱스는 visited 배열을 통해 체크하고, 선택한 숫자는 answer 배열에 저장합니다. 이후에는 다음 깊이의 재귀 호출을 수행합니다.
     * 이 코드도 이전에 작성한 코드와 동일하게 입력을 처리하고, 오름차순으로 출력합니다.
     */
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    private static int N;
//    private static int M;
//    private static int[] nums;
//    private static int[] subset;
//
//    public static void main(String[] args) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//        nums = new int[N];
//        subset = new int[M];
//        StringTokenizer numbers = new StringTokenizer(br.readLine(), " ");
//        for (int i = 0; i < N; i++) nums[i] = Integer.parseInt(numbers.nextToken());
//        Arrays.sort(nums);
//
//        Combination(0, 0);
//
//        bw.close();
//    }
//
//    private static void Combination(int cnt, int k) throws IOException {
//        if (cnt == M) {
//            for (int i = 0; i < M; i++) bw.append("" + subset[i]).append(" ");
//            bw.append("\n");
//            return;
//        }
//
//        for (int i = k; i < N; i++) {
//            subset[cnt] = nums[i];
//            Combination(cnt+1, k);
//        }
//    }
//}

    /**
     * 백트래킹 (DFS)
     */
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        visited = new boolean[N];
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);
        dfs(0, "");
    }

    public static void dfs(int depth, String answer) {
        if (depth == M) {
            System.out.println(answer.trim());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, answer + arr[i] + " ");
                visited[i] = false;
            }
        }
    }
}