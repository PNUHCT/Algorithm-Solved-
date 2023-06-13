import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1238
 */
public class no1238 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, X, M;
    private static boolean[] visitNtoX;
    private static boolean[][] visitXtoN;
    private static List<Node>[] map;
    private static int[] NtoX, XtoN;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        map = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) map[i] = new ArrayList<>();

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            map[start].add(new Node(end, cost));
        }

        /**
         * 1번째 DFS : N에서 X로 도달하는 비용을 각 도착 노드에 맞게 모두 구함
         * 2번째 DFS : X에서 N로 도달하는 비용을 각 도착 노드에 맞게 모두 구함
         * 두 값을 합산해서 최대값을 출력
         */
        
         // 1. X에서 출발하여, 각 노드에 도착할 때마다 기록(DP)
        XtoN = new int[N+1];
        Arrays.fill(XtoN, Integer.MAX_VALUE);

        for(int goal = 1 ; goal<=N ; goal++) {
            visitXtoN = new boolean[N+1][N+1];
            /*
             예외 케이스
             2(X)에서 3로 도달하기 위한 과정 중, 최소거리는 2->1->3 = (3) ,But 일반 BFS로는 2->3 = (5)
             2(X)에서 4로 도달하기 위한 과정 중, 최소거리는 2->1->3->4 = (7) // But 일반 BFS로는 (8)
             */
            if(X!=goal) XtoNBFS(goal);
        }

        // 2. 각 노드에서 출발해서 X에 도착할 떄마다 기록
        NtoX = new int[N + 1];
        for(int start = 1 ; start<=N ; start++) {
            visitNtoX = new boolean[N + 1];
            NtoXBFS(start);
        }

        XtoN[0] = XtoN[X] = 0;
        for(int num = 1 ; num<=N ; num++) XtoN[num] = XtoN[num] + NtoX[num];
        System.out.println(Arrays.stream(XtoN).max().getAsInt());
    }

    private static void XtoNBFS(int goal) {
        PriorityQueue<Node> dq = new PriorityQueue<>((a,b)->a.Cost - b.Cost);
        dq.add(new Node(X, 0));
        boolean check = false;

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            if(now.Num==goal) {
                XtoN[goal] = Math.min(now.Cost, XtoN[goal]);
                check = true;
            }

            for(Node next : map[now.Num]) {
                if(!visitXtoN[now.Num][next.Num]) {
                    dq.add(new Node(next.Num, now.Cost + next.Cost));
                    visitXtoN[now.Num][next.Num] = true;
                }
            }
        }
        if (!check) XtoN[goal] = 0;
    }

    private static void NtoXBFS(int start) {
        PriorityQueue<Node> dq = new PriorityQueue<>((a,b)->a.Cost - b.Cost);
        dq.add(new Node(start, 0));
        boolean check = false;

        while(!dq.isEmpty()) {
            Node now = dq.poll();

            if(now.Num==X) {
                NtoX[start] = now.Cost;
                check = true;
                break;
            }

            for(Node next : map[now.Num]) {
                if(!visitNtoX[next.Num]) {
                    dq.add(new Node(next.Num, now.Cost + next.Cost));
                    visitNtoX[next.Num] = true;
                }
            }
        }
        if (!check) XtoN[start] = 0;
    }

    private static class Node {
        private int Num, Cost;

        public Node(int num, int cost) {
            this.Num = num;
            this.Cost = cost;
        }
    }
}

