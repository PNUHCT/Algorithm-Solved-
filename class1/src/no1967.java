import java.util.*;
import java.io.*;

/**
 * 트리의 지름 = 두 노드 사이의 거리가 가장 긴 경로를 구하는 것
 * 즉, Node A -> Node B 의 이동에 따른 비용이 다 다르므로,
 * 모든 노드를 대상으로, 둘 사이가 이동이 가능할 때, 최대 비용 경로를 구하는 것
 */

public class no1967 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, max; // 노드의 개수
    private static Integer[][] map; // Null 인경우를 경로가 없는 것으로 처리하기 위함
    private static boolean[][] visited;

    
    public static void main (String[] args) throws IOException {
         N = Integer.parseInt(br.readLine());
         map = new Integer[N+1][N+1];
         max = Integer.MIN_VALUE;

         for(int i=1 ; i<N; i++) {  // 조건이 N-1만큼의 간선(Edge)가 주어짐
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            map[A][B] = map[B][A] = Integer.parseInt(st.nextToken()); // 트리의 경우 방향이 없으므로 양방향 모두 같은 비용으로 저장
         }

         for( int departue = 1 ; departue<=N ; departue++ ) {
            for( int arrival = 1 ; arrival<=N ; arrival++ ) {
                visited = new boolean[N+1][N+1];
                BFS(departue, arrival);
            }
         }
         System.out.println(max);
    }

    private static void BFS(int start, int goal) {
        int result = Integer.MIN_VALUE;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.Sum - a.Sum); // 최대 합계를 구해야 하므로, 내림차순 정렬
        pq.add(new Node(start, 0));
        visited[start][start] = true;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.Now == goal) {
                result = now.Sum;
                break;
            }

            for(int next=1 ; next<=N ; next++) {
                if(!visited[now.Now][next] && map[now.Now][next]!=null) {
                    visited[now.Now][next] = true;
                    pq.add(new Node(next, now.Sum + map[now.Now][next]));
                }
            } 
        }

        if(result>=max) max = result;
    }

    private static class Node {
        private int Now;
        private int Sum;

        public Node (int now, int sum) {
            this.Now = now;
            this.Sum = sum;
        }
    }
}
