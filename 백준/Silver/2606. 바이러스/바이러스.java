import java.io.*;
import java.util.*;

public class Main {

    private static int node;
    private static int edge;
    private static int[][] matrix;
    private static boolean[] visited; // 방문한 열인지 체크
    private static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기화 단계
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());
        matrix = new int[node +1][node +1];
        visited = new boolean[node +1];
        for(int i = 0; i< edge; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Integer low = Integer.parseInt(st.nextToken());
            Integer col = Integer.parseInt(st.nextToken());
            matrix[low][col] = 1;
            matrix[col][low] = 1;
        }

        DFS(1);

        System.out.println(set.size());
    }

    private static void DFS (int start) {
        visited[start] = true;

        for(int i=1 ; i<=node ; i++ ) {
            if(matrix[start][i]==1 && !visited[i]) {
                set.add(i);
                DFS(i);
            }
        }
    }
}