import java.io.*;
import java.util.*;

public class no11725 {
    private static int N;

//    private static boolean[][] map, visit;
    private static ArrayList<ArrayList<Integer>> tree;
    private static boolean[] visit;
    private static int parents[];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        // 1. 각 순서별 BFS 계산 방식
//        map = new boolean[N+1][N+1];
//        for(int i=0 ; i<N-1 ; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            int low = Integer.parseInt(st.nextToken());
//            int cul = Integer.parseInt(st.nextToken());
//            map[low][cul] = true;
//        }
//        for(int goal=2 ; goal<=N ; goal++) BFS(goal);

        // 2. 한번의 BFS에서 모든 부모노드를 구하는 방식
        tree = new ArrayList<>();
        for(int i=0 ; i<N ; i++) tree.add(new ArrayList<>());

        StringTokenizer st;
        for(int i=0 ; i<N-1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken())-1;
            int node2 = Integer.parseInt(st.nextToken())-1;
            tree.get(node1).add(node2);
            tree.get(node2).add(node1);
        }
        parents = new int[N];
        visit = new boolean[N];
        BFS();
        for(int i=1; i<N ; i++) bw.write(parents[i]+1+"\n");

        bw.close();
    }

//    private static void BFS (int goal) throws IOException {
//        Deque<Node> dq = new ArrayDeque<>();
//        visit = new boolean[N+1][N+1];
//        for(int i=1 ; i<=N ; i++) {
//            for(int j=1 ; j<=N ; j++) {
//                if(i==1 && map[i][j]) {
//                    dq.add(new Node(1, j));
//                    visit[1][j] = true;
//                }
//                if(j==1 && map[i][j]) {
//                    dq.add(new Node(1, i));
//                    visit[1][i] = true;
//                }
//            }
//        }
//
//        while(!dq.isEmpty()) {
//            Node now = dq.poll();
//            if(now.Child==goal) {
//                bw.write("" + now.Parent + "\n");
//                break;
//            }
//
//            for(int next=1 ; next<=N ; next++) {
//                if(map[now.Child][next]) {
//                    visit[now.Child][next] = true;
//                    dq.add(new Node(now.Child, next));
//                }
//                if(map[next][now.Child]) {
//                    visit[next][now.Child] = true;
//                    dq.add(new Node(now.Child, next));
//                }
//            }
//        }
//    }
//
//    private static class Node {
//        private int Parent, Child;
//        public Node(int parent, int child) {
//            this.Parent = parent;
//            this.Child = child;
//        }
//    }

    private static void BFS() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        visit[0] = true;

        while(!dq.isEmpty()) {
            int now = dq.poll();
            for(int next : tree.get(now)) {

                // 새로운 노드 방문시, 방문체크와 동시에 해당 노드의 부모노드를 저장
                if(!visit[next]) {
                    visit[next] = true;
                    dq.add(next);
                    parents[next] = now;
                }
            }
        }
    }
}