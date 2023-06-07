import java.io.*;
import java.util.*;


/**
 * 주어진 campus라는 맵에서
 * 도연(I)가 이동 가능한 칸에 한해서
 * 친구(P)의 개수를 구해라
 * 만약 없으면 TT 출력
 */
public class no21736 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static char[][] campus;
    private static int N, M;
    private static int Pcount = 0;
    private static int[] DY = new int[2];
    private static int[] hor = {0, 0, -1, 1};
    private static int[] ver = {-1, 1, 0, 0};
    private static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        campus = new char[N][M];

        /**
         * 입력 초기화 및 도연이 위치 파악
         */
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = line.charAt(j);  // String.valueOf 연산에 의한 메모리 사용 절감
                if (campus[i][j]=='I') {
                    DY[0] = i;
                    DY[1] = j;
                }
            }

        }

        BFS(); // 지도 탐색 호출

        /**
         * 도달한 P의 개수가 하나 이상이면 Pcount 출력
         * 하나도 없으면 TT 출력
         */
        System.out.println(Pcount != 0 ? Pcount : "TT");
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(DY[0], DY[1]));
        visit = new boolean[N][M];
        visit[DY[0]][DY[1]] = true;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            for (int next = 0; next < 4; next++) {
                int nextY = now.Y + ver[next];
                int nextX = now.X + hor[next];

                if (nextY < 0 || N <= nextY || nextX < 0 || M <= nextX) continue;

                if (campus[nextY][nextX]=='X') {  // 벽인 칸이면 방문체크만 해주고 무시
                    visit[nextY][nextX] = true;
                    continue;
                }

                if (campus[nextY][nextX]=='P') { // 친구만나면, 다음엔 세지않고 통과만 되도록 O으로 변경해줌
                    Pcount++;
                    campus[nextY][nextX] = 'O';
                }

                if (!visit[nextY][nextX]) {
                    dq.add(new Node(nextY, nextX));
                    visit[nextY][nextX] = true;
                }
            }
        }
    }

    /**
     * 좌표값 저장 객체용 클래스
     */
    private static class Node {
        private int Y, X;

        public Node(int y, int x) {
            this.Y = y;
            this.X = x;
        }
    }
}

