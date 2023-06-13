import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1238
 */
public class no1238 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, X, M;
    private static int max = 0;
    private static boolean[] visit;
    private static List<Node>[] map;
    private static int[] memoryX, memoryN;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        map = new ArrayList[M + 1];

        for (int i = 1; i <= M; i++) map[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, cost));
        }

//        for (int start = 1; start <= M; start++) {
//            if (start == X) continue;
//            visit = new boolean[M + 1];
//            visit[start] = true;
//            DFS(start, 0);
//        }

//        visit = new boolean[M + 1];
//        visit[X] = true;
//        DFS(X, 0);

        /**
         * 1번째 DFS : N에서 X로 도달하는 비용을 각 도착 노드에 맞게 모두 구함
         * 2번째 DFS : X에서 N로 도달하는 비용을 각 도착 노드에 맞게 모두 구함
         * 두 값을 합산해서 최대값을 출력
         */
        
         // 1. X에서 출발하여, 각 노드에 도착할 때마다 기록(DP)
        memoryX = new int[N+1];
        DFS(X, 0);

        // 2. 각 노드에서 출발해서 X에 도착할 떄마다 기록
        memoryN = new int[N+1];
        for(int goal = 1 ; goal<=N ; goal++) {
            visit = new boolean[N+1];
            visit[X] = true;
            BFS(goal);
        }

        System.out.println(max);
    }

    private static void DFS(int departure, int sum) {
        memoryX[departure] = sum;
        for (Node next : map[departure]) {
            if (!visit[next.Num]) {
                visit[next.Num] = true;
                DFS(next.Num, sum + next.Cost);
            }
        }
    }

    private static void BFS(int goal) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(X, 0));
        
        while(!dq.isEmpty()) {
            Node now = dq.poll();
        
            if(now.Num==goal) {
                memoryN[goal] = now.Cost;
                break;
            }
            
            /* 이 부분 작성하기 
                map[now.Num]에 포함된 Node들을 돌면서, next.Num이 방문한 적이 없다면,
                방문하기
            */ 
            for(Node next : map[now.Num]) {
                
            }
        }
    }

    private static class Node {
        private int Num, Cost;

        public Node(int num, int cost) {
            this.Num = num;
            this.Cost = cost;
        }
    }
}

