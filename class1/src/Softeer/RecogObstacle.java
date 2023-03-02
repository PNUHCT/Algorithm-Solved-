package Softeer;

import java.io.*;
import java.util.*;

public class RecogObstacle {
    static int[] ver = {-1, 1, 0, 0};
    static int[] hor = {0, 0, -1, 1};
    static int[][] matrix;
    static boolean[][] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    list.add(BFS(i, j));
                }
            }
        }
        bw.write("" + list.size() + "\n");
        list.sort(Comparator.naturalOrder());
        for (int i = 0; i < list.size(); i++) bw.write("" + list.get(i) + "\n");

        bw.close();
    }

    private static int BFS(int nowI, int nowJ) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(nowI, nowJ));
        int count = 0;
        while (!dq.isEmpty()) {
            Node now = dq.poll();
            count++;
            visited[now.Y][now.X] = true;

            for (int dir = 0; dir < 4; dir++) {
                int nowY = now.Y + ver[dir];
                int nowX = now.X + hor[dir];

                if (0 <= nowY && nowY < N && 0 <= nowX && nowX < N) {
                    if (matrix[nowY][nowX] == 1 && !visited[nowY][nowX]) {
                        dq.add(new Node(nowY, nowX));
                        visited[nowY][nowX] = true;
                    }
                }
            }
        }
        return count;
    }

    private static class Node {
        private int Y;
        private int X;

        public Node(int Y, int X) {
            this.Y = Y;
            this.X = X;
        }
    }
}