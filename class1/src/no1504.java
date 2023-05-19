import java.io.*;
import java.util.*;

public class no1504 {
    private static int N;
    private static int M;
    private static int[][] map; // 각 거리를 저장할 매트릭스. 0이면 간선이 없는 것.(= 이동불가)
    private static int min = -1;
    private static int sum = 0;
    // private static boolean[] visited;

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

        int fst = BFS(1, A);
        int scd = fst != 0 ? BFS(A, B) : 0;
        int last = scd != 0 ? BFS(B, N) : 0;

        if(last!=0) min = sum;
        
        System.out.println(min);
    }
    
    private static int BFS(int start, int goal) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start, 0));
        boolean[] visited = new boolean[N+1];
        int result = 0;

        while(!dq.isEmpty()) {
            Node node = dq.poll();
            int now = node.Departure;
            int nowDis = node.Distance;

            // 만약 도착하면 min 저장 후 break;
            if(now==goal) {
                sum += nowDis;
                result = now;
                break;
            }

            // 출발지점에서 경로가 있는 부분을 모두 탐색
            for(int i=0 ; i<N ; i++) {
                if(map[now][i]!=0 && !visited[i]) {
                    dq.add(new Node(i, nowDis + map[now][i])); // 현재 도착지점을 다음 출발지점으로, 현재 이동거리 + 다음 출발지점까지의 이동거리
                    visited[i] = true;
                } 
            }
        }
        return result;
    }

    private static class Node {
        private int Departure; // 출발지점 == 직전 도착지점
        private int Distance; // 누적거리

        public Node (int departure, int distance) {
            this.Departure = departure;
            this.Distance = distance;
        }
    }
}