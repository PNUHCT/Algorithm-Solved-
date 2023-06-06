import java.io.*;
import java.util.*;

public class no14940 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, baseY, baseX;
    private static String[][] map;
    private static int[][] distance;
    private static boolean[][] visit;
    private static int[] ver = {-1, 1, 0, 0};
    private static int[] hor = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        // 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        boolean check = false;

        for(int i=0; i<N ; i++) {
            map[i] = br.readLine().split(" ");
            if(!check) { // 이 조건이 없으면, map 초기화시 모든칸을 이중반복이 돌게 됨(한번 2을 찾으면 그 뒤론 반복이 필요없으므로 설정해둠)
                for (int j = 0; j < M; j++) {
                    if (map[i][j].equals("2")) {
                        baseY = i;
                        baseX = j;
                        check = true;
                        break;
                    }
                }
            }
        }

        // 실질적인 탐색 구간
        visit = new boolean[N][M];
        distance = new int[N][M];
        BFS();

        // distance에 있는 모든 값을 출력용으로 입력
        for(int Y=0; Y<N; Y++) {
            for(int X=0; X<M; X++) {
                if(!visit[Y][X] && map[Y][X].equals("1")) bw.write("-1 "); // 도달 못한칸은 visit가 false상태이며, 해당칸이 활성화된 칸이면 1이기 때문
                else bw.write(distance[Y][X] + " ");
            }
            bw.write("\n");  // 한 줄 입력완료
        }

        bw.close();
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(baseY, baseX, 0)); // 첫 칸
        visit[baseY][baseX] = true;

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            for(int move=0 ; move<4 ; move++) { // 현재칸으로부터 상하좌우 좌표이동을 위한 4번 반복
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];
                if(nextY<0 || N<=nextY || nextX<0 || M<=nextX) continue; // 범위를 벗어나면 패스

                if(map[nextY][nextX].equals("0")) continue; // 0이면 못가는 칸이므로 패스(초기화 되어 어차피 0으로 되어있음)

                if(!visit[nextY][nextX]) {
                    dq.add(new Node(nextY, nextX, now.Cnt+1));  // 다음칸이 계산한 적이 없고, 이동가능한 경우 이동
                    distance[nextY][nextX] = now.Cnt + 1;  // 각 칸의 거리를 map과 같은 크기의 distance에 기록
                    visit[nextY][nextX] = true; // 방문체크
                }
            }
        }
    }

    private static class Node {
        private int Y, X, Cnt;
        public Node(int y, int x, int cnt) {
            Y = y;
            X = x;
            Cnt = cnt;
        }
    }
}