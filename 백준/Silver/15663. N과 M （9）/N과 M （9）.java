import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static List<Integer> nums = new ArrayList<>();
    private static int[] subset;
    private static boolean[] visited;
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        subset = new int[M];
        visited = new boolean[N];

        StringTokenizer numbers = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums.add(Integer.parseInt(numbers.nextToken()));
//        nums = nums.stream().distinct().sorted().collect(Collectors.toList()); // 중복된 항목을 제거 후 수열을 구하는 방법
        Collections.sort(nums);

        Combination(0);

        results = results.stream().distinct().collect(Collectors.toList());

        for (int i = 0; i < results.size(); i++) bw.write(results.get(i) + "\n");

        bw.close();
    }

    private static void Combination(int cnt) {
        if (cnt == M) {
            String str = "";
            for (int i = 0; i < M; i++) str += subset[i] + " ";
            results.add(str);
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visited[i]) {
                subset[cnt] = nums.get(i);
                visited[i] = true; // 방문 체크 후, 재귀를 돌리고
                Combination(cnt + 1); 
                visited[i] = false; // 재귀가 끝나면 해당 부분은 다시 방문 해제 (여기가 포인트)
            }
        }
    }
}