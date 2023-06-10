import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 트리가 주어진다.
 * 첫 줄에는 정점의 개수 V기 주어진다. (2<= V <= 100000)
 *
 * 두번째 줄부턴 출발정점, 도착정점 둘사이의거리, 도착정점 둘사이의거리 ... -1이 나온다.
 * 즉, 연결된 정점과 간선이 주어지며, 끝나면 -1이 나온다. (거리는 10000 이하의 자연수)
 *
 * 첫째 줄에 트리의 지름 (=둘 사이에 가장 긴 거리)
 */
public class no1167 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int V, Max, node;
    private static List<Node>[] map;
    private static boolean[] visit;

    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        Max = Integer.MIN_VALUE;
        map = new ArrayList[V+1];
        StringTokenizer st;

        /**
         * 정점의 조건 = 1부터 시작하는 2 이상 100000이하의 수
         */
        for(int i=1; i<=V; i++) map[i] = new ArrayList<>();

        for(int i=1; i<=V; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            while(true) {
                int endNode = Integer.parseInt(st.nextToken());
                if(endNode==-1) break;
                int cost = Integer.parseInt(st.nextToken());
                map[startNode].add(new Node(endNode, cost));
            }
        }

        /**
         * 모든 Node를 하나씩 지정해서, 각 노드에서 출발하여 말단까지 도달할 수 있는 모든 경우를 탐색할 것임.
         */
//        for(int start = 1 ; start <= V; start++) {
//            visit = new boolean[V+1]; // 각 DFS 순회 당, 방문체크 배열을 만들어줌
//            visit[start] = true;
//            DFS(start, 0); //
//        }

        visit = new boolean[V+1];
        DFS(1,0);

        visit = new boolean[V+1];
        DFS(node,0);


        System.out.println(Max);
    }

    /**
     * 처음 시작한 Node를 밑으로 갈 수 있는 모든 경로를 이동하며 이동경로당 비용을 sum으로 취합함.
     * 이후, 만약 도달한 지점이 최댓값보다 크다면, 최댓값을 업데이트해줌
     * @param departure 맨 처음에는 시작 Node이며, 재귀중에는 경로상의 직전에 이동한 하위 노드
     * @param sum 이동하면서 취합한 비용의 합
     */
    private static void DFS (int departure, int sum) {
        if(sum>Max) {
            Max = sum;
            node = departure;
        }
        visit[departure] = true; //

        // 현재 도달한 Node에서 이동가능한 경로를 모두 탐색하되, 이번 재귀중에 방문하지 않았던 Node에 한해서만 탐색 진행.
        for(Node next : map[departure]) {
            if(!visit[next.Num]) {
                visit[next.Num] = true;
                DFS(next.Num, sum + next.Cost);
            }
        }
    }

    private static class Node {
        private int Num, Cost;

        public Node (int num, int cost) {
            this.Num = num;
            this.Cost = cost;
        }
    }
}

