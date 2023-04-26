import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15650 {

    /**
     * 1부터 N까지의 숫자 중, M개를 고르는 모든 수열의 경우의 수를 구하기
     * 단, 오름차순 정렬
     * 단, N과 M은 1이상 8이하
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int M;
    private static int[] nums; // 선택할 숫자들을 넣어둘 배열
    private static int[] subset; // 선택한 숫자들을 넣어둘 배열

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
        // 만약 목표한 개수(M)만큼 도달하면 -> subset에 숫자가 가득 찼으므로 -> BufferedWriter에 저장
        // 이때, 문제의 형식상 숫자를 차례대로 공백으로 구분해서 입력하고, 한 줄의 수열이 끝날때마다 줄바꿈을 넣어준 것
        // 만약 괄호와 쉼표를 이용해 구분한다면, Arrays.toString()을 사용하면 된다.
        if (cnt == M) {
            for(int i = 0 ; i< M ; i++) bw.append(""+subset[i]).append(" ");
            bw.append("\n");
            return;
        }

        // 여기서 포인트는 k부터 시작되는 반복이라는 점이다.
        // 재귀를 통해 k값이 바뀌고, 해당 k가 주어진 숫자 N을 넘어가면, 재귀가 더이상 반복되지 않는다.
        for(int i = k ; i < N; i++) {
            subset[cnt] = nums[i];
            Combination(cnt + 1, i + 1);
        }
    }
}