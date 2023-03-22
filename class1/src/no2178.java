import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class no2178 {

    private static int[][] map;
    private static int N;
    private static int M;
    private static int[] ver = {-1, 1, 0 ,0};
    private static int[] hor = {0 ,0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * BFS 문제
         * 1. 0은 이동불가, 1은 이동 가능 : 1이 있는 좌표에 한해서 움직이기
         * 2. 1,1 -> N,M으로 이동하는 최소거리
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int [N+1][M+1];
        for(int i=1; i<=N ; i++) {
            String[] temp = br.readLine().split("");
            for(int j =1; j<=M ; j++) {
                map[i][j] = Integer.parseInt(temp[j-1]);
            }
        }

        System.out.println(BFS());
    }

    /**
     * 탐색을 위한 static 메소드
     * @return 최소값 반환 (만약 void 형식으로 원할경우, 클래스 레벨에 static int 변수를 만들어주고, 할당해주면 됨)
     */
    private static int BFS() {
        Deque<Node> dq = new ArrayDeque<>(); // queue 등 대기열 형식의 자료구조 중 가장 효율이 좋음
        dq.add(new Node(1, 1, 1)); // 첫 칸부터 세어주기때문에 count=1로 초기화
        boolean[][] visited = new boolean[N+1][M+1]; // 어차피 먼저 도착한 애가 목적지에 true 체크 하기때문에 그게 제일 빠름
        visited[1][1] = true;
        int result = 0;

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if (now.Y==N && now.X==M) result = now.Count; // 목적지에 도달했을때 (어차피 제일 먼저 도달하면 방문에 true 해주므로 한가지 값밖에 대입 안됨)

            // 상하좌우 이동을 위한 좌표 계산
            for(int move = 0; move<4 ; move++) {
                int nowY = now.Y + ver[move];
                int nowX = now.X + hor[move];
                // 현재 값이 map을 벗어나지 않고, 방문한 적이 없는좌표일 경우
                if(0<nowY && nowY<=N && 0<nowX && nowX<=M && !visited[nowY][nowX]) {
                    // 현재 값이 map 내에서 이동가능한 좌표(1)일 경우
                    if(map[nowY][nowX]==1) {
                        dq.add(new Node(nowY, nowX, now.Count + 1)); // 이동하고, 이동거리 늘려줌
                        visited[nowY][nowX] = true; // 방문 체크함
                    }
                }
            }
        }
        return result;
    }

    /**
     * 현재 위치를 나타내주기 위한 객체
     * Y,X는 각각 좌표
     * Count는 이동거리 계산
     */
    private static class Node {
        private int Y;
        private int X;
        private int Count;
        public Node (int y, int x, int count) {
            this.Y = y;
            this.X = x;
            this.Count = count;
        }
    }
}

