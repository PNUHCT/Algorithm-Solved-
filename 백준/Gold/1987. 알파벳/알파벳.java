import java.io.*;
import java.util.*;

public class Main {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int R, C;
    private static int[][] map;
    private static boolean[] visited = new boolean[26];
    private static int[] ver = {-1, 1, 0, 0};
    private static int[] hor = {0, 0, -1, 1};
    private static int answer = 1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        // 알파벳 대신 알파벳에 해당하는 아스키코드 수를 저장
        for(int i=0 ; i<R ; i++) {
            String str = br.readLine();
            for(int j=0 ; j<C ; j++) map[i][j] = str.charAt(j) - 'A';
        }

        DFS(0,0,0);

        System.out.println(answer);
    }

    private static void DFS(int Y, int X, int cnt) {
        if (visited[map[Y][X]]) {
            answer = Math.max(answer, cnt);
        } else {
            visited[map[Y][X]] = true;

            for(int move=0; move<4 ; move++) {
                int nextY = Y + ver[move];
                int nextX = X + hor[move];

                if(nextY<0 || nextX<0 || nextY >=R || nextX >= C) continue; // 맵을 벗어나면 패스

                DFS(nextY, nextX, cnt + 1);
            }

            visited[map[Y][X]] = false; // 앞선 탐색이 끝나면, 다음 탐색을 위해 다시 미방문 상태로 복구시켜줌
        }
    }
}