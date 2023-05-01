import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * N개의 자연수와 자연수 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *
 * N개의 자연수 중에서 M개를 고른 수열
 * 같은 수를 여러 번 골라도 됨 = 중복허용
 * 고른 수열은 비내림차순 = 선택된 수열은 오름차순인 경우만 허용
 */

public class no15666 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static List<Integer> nums = new ArrayList<>();
    private static int[] subset;
    private static List<String> results = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        // 입력 받는 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        subset = new int[M];

        StringTokenizer numbers = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) nums.add(Integer.parseInt(numbers.nextToken()));
        Collections.sort(nums);

        // 재귀 반복 시작
        Combination(0);

        // 중복 제거
        results = results.stream().distinct().collect(Collectors.toList());

        // 최종 결과값들 입력
        for (int i = 0; i < results.size(); i++) bw.write(results.get(i) + "\n");

        bw.close();
    }

    private static void Combination(int cnt) {
        // 원하는 만큼 뽑았을 경우
        if (cnt == M) {
            // 비내림차순이 아닌경우 통과
            for (int i = 0; i < M; i++) {
                for(int j=i; j < M; j++) {
                    if(subset[i]>subset[j]) return;
                }
            }

            // 비내림차순인 경우 결과리스트에 저장
            String str = "";
            for (int i = 0; i < M; i++) str += subset[i] + " ";
            results.add(str);
            return;
        }

        // 원하는 만큼 뽑기 전까지의 반복 (중복을 허용하기 위해서 방문체크 visited는 하지 않는다.)
        for (int i = 0; i < N; i++) {
                subset[cnt] = nums.get(i);
                Combination(cnt + 1);
        }
    }
}


/**
 * Chat GPT 코드 (DFS)
 */
//import java.util.*;
//
//public class no15666 {
//    static int[] numbers;
//    static int n, m;
//    static Set<String> answer = new HashSet<>();
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();
//        m = scanner.nextInt();
//        numbers = new int[n];
//        for (int i = 0; i < n; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        Arrays.sort(numbers);
//        dfs(new ArrayList<>(), 0);
//        List<String> output = new ArrayList<>(answer);
//        Collections.sort(output);
//        for (String s : output) {
//            System.out.println(s);
//        }
//    }
//
//    static void dfs(List<Integer> seq, int prev) {
//        if (seq.size() == m) {
//            StringBuilder sb = new StringBuilder();
//            for (int num : seq) {
//                sb.append(num).append(" ");
//            }
//            answer.add(sb.toString().trim());
//            return;
//        }
//        for (int i = prev; i < n; i++) {
//            List<Integer> newSeq = new ArrayList<>(seq);
//            newSeq.add(numbers[i]);
//            dfs(newSeq, i);
//        }
//    }
//}