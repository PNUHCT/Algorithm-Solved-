import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 1. 맵 전체를 탐색하여, 공기가 있는 위치 파악
 * 2. 치즈가 있는 위치는 사방에 두 변 이상 접촉한 공기가 있는지 파악 후, 있다면 녹이고 탐색중지
 * 3. 1과 2를 통해 얻은 치즈의 위치(치즈의 가장자리) 부분만 녹여서 공기로 전환
 * 4. 1~3의 과정을 반복하며,치즈가 체크되지 않는 경우에 반복 종료
 */
public class no2638 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, Hours;
    private static int[][] map;
    private static boolean[][] visited;
    private static StringTokenizer st;
    private static int[] ver = {-1, 1, 0, 0};
    private static int[] hor = {0, 0 ,-1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new int[N][M];
        Hours = 0;

        for(int i=0; i<N ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M ; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        while(true) {
            if(BFS()) Hours++;
            else break;
        }

        System.out.println(Hours);
    }

    private static boolean BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        visited = new boolean[N][M];
        dq.add(new Node(0,0));
        boolean exist = false;

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            for(int move=0; move<4 ; move++) {
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];

                /*
                 1. 치즈의 경우, visited인데 재방문이면 map에서 녹여주는 과정 필요
                 2. 공기의 경우, visited면 바로 패스
                 */

                if(nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue; // 범위 넘어가면 패스

                // 공기든 치즈든 방문한 적이 있을 때,
                if(visited[nextY][nextX]) {
                    if(map[nextY][nextX]==0) continue; // 이미 방문한 공기는 탐색 X
                    else {  // 한 면에 이미 공기가 닿은 치즈인 경우
                        map[nextY][nextX] = 0; // 치즈 녹여주고
                        exist = true;  // 이번 탐색에서 치즈 녹인 전적이 있음을 체크
                        continue;  // *아래 코드를 실행하지 못하도록 필수로 넣어줘야 함*
                    }
                }

                if(map[nextY][nextX]==1) visited[nextY][nextX] = true; // 치즈 가장자리를 방문체크함으로서 재탐색을 막으며, 내부 공기는 아예 탐색자체를 막음
                else { // 방문한 적 없는 외부 공기인 경우
                    visited[nextY][nextX] = true;
                    dq.add(new Node(nextY, nextX)); // 인근의 다른 칸을 탐색
                }
            }
        }

        return exist; // 이번 탐색에서 치즈를 녹였는지 여부를 리턴 : 하나라도 녹였으면 시간 + 1 해줘야 하므로
    }

    private static class Node {
        private int Y, X;
        public Node(int y, int x) {
            this.Y = y;
            this.X = x;
        }
    }
}