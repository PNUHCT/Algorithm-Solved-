import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    /**
     * field : 입력받은 맵 형태로서, true는 곧 벽이 있다는 표시다.
     */
    private static boolean[][] field;
    /**
     * DP
     * : 가로, 세로, 대각선이 가능 한 경우를 모두 등록하기위한 3차원 배열
     * : 1, 2차원은 맵을 나타내며, 3차원은 각각 0은 가로, 1은 세로, 2는 대각선인 상태를 저장하는 방식이다.
     */
    private static int[][][] DP;

    public static void main(String[] args) throws IOException {

        // 입력구간
        N = Integer.parseInt(br.readLine());
        field = new boolean[N][N];
        DP = new int[N][N][3];
        StringTokenizer st;
        for(int i=0 ; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0 ; j<N; j++) {
                if(st.nextToken().equals("1")) field[i][j] = true;
            }
        }


        DP[0][1][0] = 1; // 초기화

        // N * N을 순회하며, 구할 수 있는 경우를 순차적으로 칸마다 저장
        // 최종적으로 마지막 칸에 도달한 가로/세로/대각선은 각각의 구할 수 있는 경우의 수 합임
        for(int i=0 ; i<N ; i++) {
            for(int j=2 ; j<N ; j++) {
                // 가로일 때
                if (j-1 >= 0 && !field[i][j]) DP[i][j][0] = DP[i][j-1][0] + DP[i][j-1][2];
                // 세로일 때
                if (i-1 >= 0 && !field[i][j]) DP[i][j][1] = DP[i-1][j][1] + DP[i-1][j][2];
                // 대각선 일때
                if (i-1 >= 0 && j-1 >= 0 && !field[i][j] && !field[i-1][j] && !field[i][j-1]) {
                    DP[i][j][2] = DP[i-1][j-1][0] + DP[i-1][j-1][1] + DP[i-1][j-1][2];
                };
            }
        }

        // 최종 목적지에 도달할 때, 가로/세로/대각선으로 도달한 경우의 수를 모두 합치면 정답
        int result = DP[N-1][N-1][0] + DP[N-1][N-1][1] + DP[N-1][N-1][2];

        System.out.println(result);
    }
}