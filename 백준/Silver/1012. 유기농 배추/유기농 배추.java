import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] horX = {1, -1, 0, 0};
    static int[] verY = {0, 0, 1, -1};
    static int[][] ground;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int init = Integer.parseInt(st.nextToken());
            ground = new int [N][M];
            for(int i=0; i<init ; i++) {
                StringTokenizer temp = new StringTokenizer(br.readLine());
                int nowM = Integer.parseInt(temp.nextToken());
                int nowN = Integer.parseInt(temp.nextToken());
                ground[nowN][nowM] = 1;
            }

            int count= 0;
            visited = new boolean[N][M];

            for(int i =0; i<N ; i++) {
                for(int j =0; j<M ; j++) {
                    if(ground[i][j]==1 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void BFS(int nowI, int nowJ) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(nowI, nowJ));

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            visited[now.Y][now.X] = true;

            for(int dir=0 ; dir<4 ; dir++) {
                int nowY = now.Y + verY[dir];
                int nowX = now.X + horX[dir];

                if(nowX >=0 && nowX <M && nowY >=0 && nowY < N) {
                    if (ground[nowY][nowX] == 1 && !visited[nowY][nowX]) {
                        dq.add(new Node(nowY, nowX));
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }
    }

    static class Node {
        private int Y;
        private int X;

        public Node(int y, int x) {
            this.Y = y;
            this.X = x;
        }
    }
}

