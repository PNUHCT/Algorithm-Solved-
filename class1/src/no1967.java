import java.util.*;
import java.io.*;

public class no1967 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, max; // 노드의 개수
    private static List<Node> map[];
    private static boolean[] visited;

    
    public static void main (String[] args) throws IOException {
         N = Integer.parseInt(br.readLine());
         max = Integer.MIN_VALUE;

         map = new ArrayList[N+1];
         for(int i = 1 ; i<=N ; i++ ) map[i] = new ArrayList<>(); // 주어지는 A->B 노드 이동당 비용을 저장할 것임

         for(int i=1 ; i<N; i++) {  // 조건이 N-1만큼의 간선(Edge)가 주어짐
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 방향이 없는 트리이므로, 양방향 같은 비용으로 저장
            map[A].add(new Node(B, cost));
            map[B].add(new Node(A, cost));
         }

        /**
         * 각 Node를 순차적으로 DFS 탐색
         * DFS에서 모든 경우를 탐색하되, 최대값이 되는 경우를 max에 저장
         */

         for(int start = 1 ; start<=N ; start++) {
            visited = new boolean[N+1];
            visited[start] = true;
            DFS(start, 0);
         }

         System.out.println(max);
    }

    private static void DFS(int departue, int sum) {
        // 더이상 갈 곳이 없을때까지(visited[]내 모든 노드를 방문한 경우) 재귀 진행
        for(Node next : map[departue]) { // 직전에 출발한 곳으로부터 이동할 수 있는 모든 경로를 탐색
            if(!visited[next.Num]) { // 방문한 적이 없는 경우에 한해서 (빙빙 도는거 방지)
                visited[next.Num] = true; // 방문체크 후,
                DFS(next.Num, sum + next.Cost);  // 이동, 직전까지 합산 + 새로운 이동을 위한 비용 추가
            }
        }

        max = (max < sum) ? sum : max; // 마지막으로 저장한 최대값과 현재 합산을 비교해서 더 큰값을 저장
    }

    private static class Node {
        private int Num, Cost;

        public Node(int num, int cost) {
            this.Num = num;
            this.Cost = cost;
        }
    }
}