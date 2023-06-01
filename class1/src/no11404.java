import java.util.*;
import java.io.*;

public class no11404 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int city, bus;
    private static Integer[][] map;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());
        map = new Integer[city+1][city+1];

        for (int i=0 ; i<bus ; i++) {
            StringTokenizer busSt = new StringTokenizer(br.readLine(), " ");
            // [출발지][도착지] => 비용으로 저장
            int A = Integer.parseInt(busSt.nextToken());
            int B= Integer.parseInt(busSt.nextToken());
            int cost = Integer.parseInt(busSt.nextToken());
            if(map[A][B] == null) map[A][B] = cost;
            else map[A][B] = Math.min(map[A][B], cost); // A에서 B로 가는 비용이 한 가지 이상이다.
        }
        /**
         * 이제 맵마다 순회하며, 각각 도시별로 가는 최소비용을 " "로 구분해서 출력해야한다.
         * 예를들어, 1번째 줄은 A에서 A, B, C, D, E로 가는 최소 비용을 0 2 3 1 4로 출력하며,
         * 5번째 줄은 E에서 A, B, C, D, E로 가는 최소비용을 7 4 10 6 0으로 출력한다.
         */
        
        for (int i=1 ; i<=city ; i++) {
            for (int j=1 ; j<=city ; j++) {
                if(i==j) bw.write("0 ");
                else {
                    visited = new boolean[city+1][city+1];
                    bw.write("" + BFS(i, j) + " ");
                }
            }
            bw.write("\n");
        }
        bw.close();
    }

    private static int BFS(int start, int goal) {
        PriorityQueue<Node> pq = new PriorityQueue<>( (a, b) -> b.Sum - a.Sum);
        pq.add(new Node(start, 0));
        visited[start][start] = true;
        int min = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            
            if(now.Arrival==goal) {
                min = now.Arrival;
                break;
            }
            
            for (int next=1 ; next<=city ;next++) {
                if(!visited[now.Arrival][next] && map[now.Arrival][next]!=null) {
                    pq.add(new Node(next, now.Sum + map[now.Arrival][next]));
                    visited[now.Arrival][next] = true;
                }
            }
        }
        return min;
    }

    private static class Node {
        private int Arrival;
        private int Sum;

        public Node (int arrival, int sum) {
            this.Arrival = arrival;
            this.Sum = sum;
        }
    }
}