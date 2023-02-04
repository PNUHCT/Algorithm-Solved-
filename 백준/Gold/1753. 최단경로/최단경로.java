import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        private int arrival;
        private int distance;
        public Node(int arrival, int distance) {
            this.arrival = arrival;
            this.distance = distance;
        }
    }

    static final Integer INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] graph;
    static boolean[] visit;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        visit = new boolean[V+1];
        distance = new int [V+1];

        for(int i = 1;i<= V;i++) graph[i] = new ArrayList<>();

        for(int i=0 ; i<E ; i++) {
            StringTokenizer stE = new StringTokenizer(br.readLine(), " ");
            int departure = Integer.parseInt(stE.nextToken());
            int arrival = Integer.parseInt(stE.nextToken());
            int cost = Integer.parseInt(stE.nextToken());
            graph[departure].add(new Node(arrival, cost));
        }

        dijkstra(V, start);

        for (int i = 1; i <= V; i++) {
            System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
        }
    }

    private static void dijkstra (int V, int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        for(int i=1 ; i<V+1 ; i++) distance[i] = INF;
        distance[start] = 0;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node departure = queue.poll();

            if(!visit[departure.arrival]) visit[departure.arrival] = true;

            for(Node arrival : graph[departure.arrival]) {
                if(!visit[arrival.arrival] && distance[arrival.arrival] > departure.distance + arrival.distance ) {
                    distance[arrival.arrival] = departure.distance + arrival.distance;
                    queue.add(new Node(arrival.arrival, distance[arrival.arrival]));
                }
            }
        }
    }
}