import java.io.*;
import java.util.*;

public class no1504 {
    private static int N, M;
    private static int[][] map; // 각 거리를 저장할 매트릭스. 0이면 간선이 없는 것.(= 이동불가)
    private static boolean[] visited;
    private static int INF = 200000 * 1000; // 최대 간선의 수 * 최대 가중치 : 즉, 최대 누적 가중치는 200000000을 넘을 수 없다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정점의 수와 간선의 수를 구함
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 각 정점과 노드 사이에 연결과 거리를 넣어줌 (연결이 안된경우 값이 0)
        map = new int[N+1][N+1];
        for(int i=0 ; i<M ; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            int departure = Integer.parseInt(input.nextToken());
            int arrive = Integer.parseInt(input.nextToken());
            map[departure][arrive] = map[arrive][departure] = Integer.parseInt(input.nextToken());
        }        

        // 지나야 하는 두 정점
        StringTokenizer goals = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(goals.nextToken());
        int B = Integer.parseInt(goals.nextToken());
        
        /**
         * 아래 두 가지 경우의 수 중, 더 짧은 누적거리를 출력.
         * 만약 최소 누적거리가 INF보다 크거나 같다면, 경로가 없음을 나타냄.
         * 
         * 1 -> A -> B -> N
         * 1 -> B -> A -> N
         * 
         * 이때, 각 구간당 방문체크 후, 다음 구간을 탐색할 때는 방문체크가 초기화 되므로 중복 방문이 허용된다
         */

        int first1 = Dijkstra(1, A);
        int first2 = Dijkstra(A, B);
        int first3 = Dijkstra(B, N);
        int first = first1 + first2 + first3;

        int second1 = Dijkstra(1, B);
        int second2 = Dijkstra(B, A);
        int second3 = Dijkstra(A, N);
        int second = second1 + second2 + second3;

        // int min = first <= second ? first : second;
        // int answer = min <= INF ? min : -1;

        // System.out.println(answer);

        if(first1 >= INF || first2>= INF || first3 >= INF || second1 >= INF || second2 >= INF || second3 >= INF) System.out.println(-1);
        else if (first<= second) System.out.println(first);
        else System.out.println(second);
    }

    private static int Dijkstra (int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.Dist - b.Dist);
        pq.add(new Node(start, 0));
        visited = new boolean[N+1];
        visited[start] = true;
        int result = INF;
        
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.Next;
            
            if(now==end) {
                result = node.Dist;
                break;
            }

            for(int i=1 ; i<N+1 ; i++) {
                if(map[now][i]!=0 && !visited[i]) {
                    visited[i] = true;
                    pq.add(new Node(i, node.Dist+map[now][i]));
                }
            }
        }
        return result;
    }

    private static class Node {
        private int Next;
        private int Dist;
        
        public Node (int next, int dist) {
            this.Next = next;
            this.Dist = dist;
        }
    }
}