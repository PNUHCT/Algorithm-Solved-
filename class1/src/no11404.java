import java.util.*;
import java.io.*;

public class no11404 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int city, bus;
    private static Integer[][] map;
    private static boolean[][] visited;

    /**
     * 
     */
    public static void main(String[] args) throws IOException {
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        map = new Integer[city+1][city+1];

        for (int i=0 ; i<bus ; i++) {
            StringTokenizer busSt = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(busSt.nextToken())][Integer.parseInt(busSt.nextToken())] = Integer.parseInt(busSt.nextToken());
        }
        
        /**
         * 이제 맵마다 순회하며, 각각 도시별로 가는 최소비용을 " "로 구분해서 출력해야한다.
         * 예를들어, 1번째 줄은 A에서 A, B, C, D, E로 가는 최소 비용을 0 2 3 1 4로 출력하며,
         * 5번째 줄은 E에서 A, B, C, D, E로 가는 최소비용을 7 4 10 6 0으로 출력한다.
         * DFS 사용?
         */

        visited = new boolean[city][city];

        for(int i = 0 ; i<city ; i++) {
            for(int j = 0 ; j<city ; j++) {
//                if(!visited[i][j]) {
                    bw.write(""+DFS(i, j, 0)+" ");
//                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    private static int DFS(int departure, int goal, int sum) {
        if(departure==goal) return sum;

        for(int j = 0 ; j<city ; j++) {
            if(!visited[departure][goal] && map[departure][j]!=null) {
                visited[departure][goal] = true;
                return DFS(j, goal, sum + map[departure][j]);
            }
        }
        return sum;
    }
}
