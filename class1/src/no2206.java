import java.io.*;
import java.util.*;

public class no2206 {

    /**
     * 1. BFS 탐색 진행
     * 2. 객체에 벽을 부술수 있는 능력을 1회 부여
     * 3. 만약 0일경우 통과
     * 4. 만약 1일경우, 능력이 남아 있다면 능력 -1하고 통과
     */
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static String[][] map;
    private static boolean[][] visited;
    private static int[] hor = {-1, 1, 0, 0};
    private static int[] ver = {0, 0, -1, 1};
    private static int N, M;
    private static int min = 1000001;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");    
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visited = new boolean[N][M];

        for(int i=0 ; i<N ; i++) {
            String temp = br.readLine();
            for (int j=0 ; j<M ; j++) map[i][j] = String.valueOf(temp.charAt(j));
        }

        BFS();

        if(min == 1000001) System.out.println(-1);
        else System.out.println(min);
    }

    private static void BFS () {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 1, 1));
        visited[0][0] = true;

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            int nowX = now.X;
            int nowY = now.Y;
            visited[nowY][nowX] = true;

            if(nowY == N-1 && nowX == M-1) {
                min = now.Step;
                break;
            }

            for(int i = 0 ; i<4 ; i++) {
                int nextX = nowX+hor[i];
                int nextY = nowY+ver[i];

                if(0<=nextY && nextY<N && 0<=nextX && nextX<M && !visited[nextY][nextX]) {

                    // 1일때
                    if(map[nextY][nextX].equals("1")) {
                        if(now.Chance==1) { // 벽을 부술때
                            dq.add(new Node(nextX, nextY, now.Step+1, 0));
                        } 
                    } 

                    // 0일때
                    else if(now.Chance==0) { // map에서 0일 경우 중, 벽 부술 찬스가 없는 경우
                        dq.add(new Node(nextX, nextY, now.Step+1, 0));
                    } else { // map에서 0일 경우 중, 벽 부술 찬스가 있는 경우
                        dq.add(new Node(nextX, nextY, now.Step+1, 1));
                    }

                    // visited[nextY][nextX] = true;
                }               
            }
        }
    }

    private static class Node {
        private int X;
        private int Y;
        private int Step;
        private int Chance;

        public Node (int x, int y, int step, int chance) {
            this.X = x;
            this.Y = y;
            this.Step = step;
            this.Chance = chance;
        }
    }
}
