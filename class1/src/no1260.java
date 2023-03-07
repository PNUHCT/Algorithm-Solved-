import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no1260 {

    private static int node;
    private static int edge;
    private static int[][] matrix;
    private static boolean[] visitedDFS;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 세팅
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        matrix = new int[node + 1][node + 1];
        int start = Integer.parseInt(st.nextToken());

        for (int i = 0; i < edge; i++) {
            StringTokenizer tempSt = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(tempSt.nextToken());
            int node2 = Integer.parseInt(tempSt.nextToken());
            matrix[node1][node2] = matrix[node2][node1] = 1; // 양방향 체크
        }

        visitedDFS = new boolean[node + 1];
        DFS(start);

        bw.write("\n");

        BFS(start);

        bw.close();
    }

    /**
     * DFS 로 탐색
     */
    private static void DFS(int start) throws IOException {
        visitedDFS[start] = true;
        bw.write("" + start + " ");

        for (int i = 1; i <= node; i++) {
            if (matrix[start][i] == 1 && !visitedDFS[i]) {
                DFS(i);
            }
        }
    }


    /**
     * BFS 로 탐색
     */
    private static void BFS(int start) throws IOException {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);
        boolean[] visitedBFS = new boolean[node + 1];
        visitedBFS[start] = true;

        while (!dq.isEmpty()) {
            int now = dq.poll();
            bw.write("" + now + " ");

            for (int i = 1; i <= node; i++) {
                if (matrix[now][i] == 1 && !visitedBFS[i]) {
                    dq.add(i);
                    visitedBFS[i] = true;
                }
            }
        }
    }
}