import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[][] map; // 각 거리를 저장할 매트릭스. 0이면 간선이 없는 것.(= 이동불가)
    private static int min = 9999999;
    private static int[] goal = new int[2];
    private static boolean[] visited;

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
        goal[0] = Integer.parseInt(goals.nextToken());
        goal[1] = Integer.parseInt(goals.nextToken());

        // 아무 정점에서나 시작할 수 있는 경우 탐색
        // for (int i=0; i<N ; i++) {
        //     BFS(i);
        // }
        
        BFS(1);

        if(min == 9999999) System.out.println(-1);
        else System.out.println(min);
    }
    
    private static void BFS(int departure) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(departure, 0));
        visited = new boolean[N+1];

        while(!dq.isEmpty()) {
            Node node = dq.poll();
            int now = node.Departure;
            int nowDis = node.Distance;
            
            // 만약 현재 마일리지가 min보다 크면 continue; (사실상 최초 min에서 이미 반복이 끝나므로 필요 없는 예외)

            // 만약 도착하면 min 저장 후 break;
            if(visited[goal[0]] && visited[goal[1]] && now==N) {
                min = nowDis;
                break;
            }

            // 출발지점에서 경로가 있는 부분을 모두 탐색
            for(int i=0 ; i<N ; i++) {
                if(map[now][i]!=0) {
                    dq.add(new Node(i, nowDis + map[now][i])); // 현재 도착지점을 다음 출발지점으로, 현재 이동거리 + 다음 출발지점까지의 이동거리
                    visited[i] = true;
                } 
            }
        }
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