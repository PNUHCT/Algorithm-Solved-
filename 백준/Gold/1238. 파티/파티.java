import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
public class Main {
 
    private static final int INF = 1000000000;
 
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M, X;
    private static List<List<Node>> list, reverseList;
    private static int[] dist, reverseDist;
 
    static class Node implements Comparable<Node> {
        int index;
        int distance;
 
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
 
        public int compareTo(Node n) {
            return this.distance - n.distance;
        }
    }
 
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
 
        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }
 
        dist = new int[N + 1];
        reverseDist = new int[N + 1];
        Arrays.fill(dist, INF);
        Arrays.fill(reverseDist, INF);
 
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
 
            list.get(u).add(new Node(v, weight));
            reverseList.get(v).add(new Node(u, weight));
        }
 
        dijkstra(list, dist, X);
        dijkstra(reverseList, reverseDist, X);
 
        print();
        br.close();
    }
 
    private static void dijkstra(List<List<Node>> list, int[] distance, int start) {
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
 
        distance[start] = 0;
 
        while (!pq.isEmpty()) {
            int idx = pq.poll().index;
 
            if (visited[idx]) continue;
            visited[idx] = true;
 
            for (Node node : list.get(idx)) {
                if (distance[node.index] > distance[idx] + node.distance) {
                    distance[node.index] = distance[idx] + node.distance;
                    pq.add(new Node(node.index, distance[node.index]));
                }
            }
        }
    }
 
    private static void print() {
        int ans = -1;
        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, dist[i] + reverseDist[i]);
        }
        System.out.println(ans);
    }
}