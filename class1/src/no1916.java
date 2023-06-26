import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 1. N+1 * N+1의 Integer 맵 만들기
 * 2. 입력을 받으며, 만약 이전 값이 null이 아닌 경우 더 작은 값을 입력(최소비용)
 * 3. PriorityQueue BFS 탐색을 통해, 합산비용이 제일 적은 부분부터 탐색
 * 4. B지점 도착시 종료
 */
public class no1916 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, A, B, result;
    private static Integer[][] map;
    private static boolean[][] visit; // 중간 경유지마다 출발/도착 city가 다르므로, 일차원 배열로는 방문체크가 안됨

    public static void main(String[] args) throws IOException {
        // 초기 입력 단계
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new Integer[N+1][N+1];
        StringTokenizer st;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(map[start][end] != null) map[start][end] =  Math.min(map[start][end], cost);
            else map[start][end] = cost;
        }

        st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        BFS(); // 실질적인 탐색 구간

        System.out.println(result);
    }

    private static void BFS() {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        visit = new boolean[N+1][N+1];
        pq.add(new Node(A, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(now.city == B) {
                result = now.cost;
                break;
            }

            for(int next = 1; next <= N; next++) {
                if(!visit[now.city][next] && map[now.city][next]!=null) {
                    pq.add(new Node(next, map[now.city][next] + now.cost));
                    visit[now.city][next] = true;
                }
            }
        }
    }

    private static class Node {
        private int city, cost;
        public Node(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}

