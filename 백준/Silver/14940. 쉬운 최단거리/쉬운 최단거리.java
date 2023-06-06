import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, baseY, baseX;
    private static String[][] map;
    private static int[][] distance;
    private static boolean[][] visit;
    private static int[] ver = {-1, 1, 0, 0};
    private static int[] hor = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new String[N][M];
        boolean check = false;

        for(int i=0; i<N ; i++) {
            map[i] = br.readLine().split(" ");
            if(!check) {
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

        visit = new boolean[N][M];
        distance = new int[N][M];

        BFS();

        for(int Y=0; Y<N; Y++) {
            for(int X=0; X<M; X++) {
                if(!visit[Y][X] && map[Y][X].equals("1")) bw.write("-1 ");
                else bw.write(distance[Y][X] + " ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(baseY, baseX, 0));
        visit[baseY][baseX] = true;

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            for(int move=0 ; move<4 ; move++) {
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];
                if(nextY<0 || N<=nextY || nextX<0 || M<=nextX) continue;

                if(map[nextY][nextX].equals("0")) continue;

                if(!visit[nextY][nextX]) {
                    dq.add(new Node(nextY, nextX, now.Cnt+1));
                    distance[nextY][nextX] = now.Cnt + 1;
                    visit[nextY][nextX] = true;
                }
            }
        }
    }

    private static class Node {
        private int Y;
        private int X;
        private int Cnt;
        public Node(int y, int x, int cnt) {
            Y = y;
            X = x;
            Cnt = cnt;
        }
    }
}