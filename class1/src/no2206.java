import java.io.*;
import java.util.*;

public class no2206 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // private static String[][] map;
    // private static boolean[][] visited;
    // private static int[] hor = {-1, 1, 0, 0};
    // private static int[] ver = {0, 0, -1, 1};
    // private static int N, M;
    // private static int min = 1000001;
    // public static void main(String[] args) throws IOException {
    //     StringTokenizer st = new StringTokenizer(br.readLine(), " ");    
    //     N = Integer.parseInt(st.nextToken());
    //     M = Integer.parseInt(st.nextToken());

    //     map = new String[N][M];
    //     visited = new boolean[N][M];

    //     for(int i=0 ; i<N ; i++) {
    //         String temp = br.readLine();
    //         for (int j=0 ; j<M ; j++) map[i][j] = String.valueOf(temp.charAt(j));
    //     }

    //     BFS();

    //     if(min == 1000001) System.out.println(-1);
    //     else System.out.println(min);
    // }

    // private static void BFS () {
    //     Deque<Node> dq = new ArrayDeque<>();
    //     dq.add(new Node(0, 0, 1, 1));
    //     visited[0][0] = true;

    //     while(!dq.isEmpty()) {
    //         Node now = dq.poll();
    //         int nowX = now.X;
    //         int nowY = now.Y;

    //         if(nowY == N-1 && nowX == M-1) {
    //             min = now.Step;
    //             break;
    //         }

    //         for(int i = 0 ; i<4 ; i++) {
    //             int nextX = nowX+hor[i];
    //             int nextY = nowY+ver[i];

    //             if(0<=nextY && nextY<N && 0<=nextX && nextX<M && !visited[nextY][nextX]) {

    //                 // 1일때
    //                 if(map[nextY][nextX].equals("1")) {
    //                     if(now.Chance==1) { // 벽을 부술때
    //                         dq.add(new Node(nextX, nextY, now.Step+1, 0));
    //                     } 
    //                 } 

    //                 // 0일때
    //                 else if(now.Chance==0) { // map에서 0일 경우 중, 벽 부술 찬스가 없는 경우
    //                     dq.add(new Node(nextX, nextY, now.Step+1, 0));
    //                 } else { // map에서 0일 경우 중, 벽 부술 찬스가 있는 경우
    //                     dq.add(new Node(nextX, nextY, now.Step+1, 1));
    //                 }

    //                 visited[nextY][nextX] = true;
    //             }               
    //         }
    //     }
    // }

    // private static class Node {
    //     private int X;
    //     private int Y;
    //     private int Step;
    //     private int Chance;

    //     public Node (int x, int y, int step, int chance) {
    //         this.X = x;
    //         this.Y = y;
    //         this.Step = step;
    //         this.Chance = chance;
    //     }
    // }

    private static class Node {
        private int Y;
        private int X;
        private int Step;
        private int Chance;

        public Node (int y, int x, int step, int chance) {
            this.Y = y;
            this.X = x;
            this.Step = step;
            this.Chance = chance;
        }
    }

    private static int N, M;
    private static char[][] map;
    private static int[] ver = {0,0,-1,1};
    private static int[] hor = {-1,1,0,0};

    private static boolean[][][] visited = new boolean[N][M][2]; // 벽을 부수는 탐색과, 부수지 않는 탐색때문에 3차원의 크기가 2임

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i=0 ; i<N ; i++) {
            String input = br.readLine();
            for (int j=0 ; j<M ; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        int result = BFS();
        System.out.println(result);
    }

    private static int BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(0, 0, 1, 1));
        visited = new boolean[N][M][2];

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            // 최초 도달지점은 곧 최소 스텝
            if(now.Y == N-1 && now.X == M-1) return now.Step;

            for(int i=0 ; i<4 ; i++) {
                int nextY = now.Y + ver[i];
                int nextX = now.X + hor[i];

                if(nextY<0 || N<=nextY || nextX<0 || M<=nextX) continue;

                // 벽이 아닐 경우
                if(map[nextY][nextX]=='0') {
                    // 벽을 부순적이 없는 경우 => 벽 부술 기회 유지
                    if(now.Chance > 0 && !visited[nextY][nextX][0]) {
                        dq.add(new Node(nextY, nextX, now.Step+1, now.Chance));
                        visited[nextY][nextX][0] = true;
                    }
                    // 벽을 부순적이 있는 경우 => 벽 부술 기회 없는 것 체크
                    else if (now.Chance == 0 && !visited[nextY][nextX][1]) {
                        dq.add(new Node(nextY, nextX, now.Step +1, now.Chance));
                        visited[nextY][nextX][1] = true;
                    }
                } 

                // 벽인 경우
                else if(map[nextY][nextX]=='1') {
                    // 벽을 부순적이 없는 경우 => 벽 부술 기회 - 1
                    if(now.Chance > 0) {
                        dq.add(new Node(nextY, nextX, now.Step + 1, now.Chance - 1));
                        visited[nextY][nextX][1] = true;
                    }
                    // 벽 부순적이 있는 경우 여기서 중지(아무런 조취 X)
                }
            }
        }
        
        return -1;
    }
}
