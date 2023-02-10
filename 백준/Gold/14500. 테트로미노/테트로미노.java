import java.io.*;
import java.util.*;

public class Main {

    private static Set<Integer> set = new HashSet<>();
    private static int N;
    private static int M;
    private static int[][] matrix; // 실제 값이 들어갈 매트릭스
    static boolean[][] visited;  // 방문 확인용 매트릭스
    static int[] dy = {-1,1,0,0};  // 엣지케이스의 도형을 구하기 위함
    static int[] dx = {0,0,-1,1};  // 엣지케이스의 도형을 구하기 위함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        matrix = new int[N][M];

        for(int i=0; i<N ; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++) matrix[i][j] = Integer.parseInt(temp.nextToken());
        }

        /**
         * 각 좌표의 값 하나하나에 대해 탐색을 해줄 것임
         */
        for (int H = 0; H <N; H++) {
            for (int W = 0; W < M; W++) {

                /**
                 * 일반 케이스를 구하는 DFS 탐색
                 */
                visited[H][W] = true;
                DFS(1, matrix[H][W], H,W);

                /**
                 * DFS로 구할 수 없는 ㅓ,ㅗ,ㅏ,ㅜ 형태인 경우를 구하는 공식
                 */
                visited[H][W] = false;
                edgeCase(0, 0, H, W, matrix[H][W]);	//인접한 4칸 중 3칸 고르기(ㅗ,ㅓ,ㅏ,ㅜ 모양)
            }
        }
        /**
         * set에 몰빵으로 담아놓은 합산 중 가장 큰 값을 반영
         */
        int result = set.stream().mapToInt(a->a).max().getAsInt();
        System.out.println(result);
    }


    /**
     * 순차적으로 연달아 붙이면서 만들 수 있는 도형
     * @param cnt 1~4번째 depth까지 탐색할 예정
     * @param point 합산
     * @param nowH 높이(세로축) : 이중배열 중 첫번째 칸
     * @param nowW 넓이(가로축) : 이중배열 중 두번째 칸
     */
    private static void DFS(int cnt, int point, int nowH, int nowW) {
        if(cnt==4) set.add(point);
        else {
            for(int depth = 0; depth <4 ;depth++) {
                int H = nowH + dy[depth];
                int W = nowW + dx[depth];

                if(H<0 || H >= N || W<0 || W>=M ) continue;
                if(visited[H][W]) continue;

                visited[H][W] = true;
                DFS(cnt+1, point + matrix[H][W], H, W);
                visited[H][W] = false;
            }
        }
    }


    /**
     * 가운데 뽈록 하나 나온 도형 (순차적으로 붙이기 불가능) == 교차로형태 == 십자가형태
     */
    private static void edgeCase(int cnt, int start, int nowH, int nowW, int sum) {
        if(cnt == 3) set.add(sum);
        else {
            for (int depth = start; depth < 4; depth++) {
                int H = nowH + dy[depth];
                int W = nowW + dx[depth];

                if (H < 0 || H >= N || W < 0 || W >= M) continue;

                edgeCase(cnt + 1, depth + 1, nowH, nowW, sum + matrix[H][W]);
            }
        }
    }
}