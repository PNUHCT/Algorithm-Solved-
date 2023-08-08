import java.util.*;
 
public class Main {
    
    static ArrayList<Node>[] list;
    static int n, m, start, end; 
    static int[] dist;
    static int[] route; // 직전 노드 저장
    static boolean[] visited; 
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        n = scan.nextInt();
        m = scan.nextInt();
        
        list = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int c = scan.nextInt();
            list[s].add(new Node(e, c));
        }
        
        start = scan.nextInt();
        end = scan.nextInt();
        
        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, 1000000001);
        visited = new boolean[n + 1];
        dijkstra();
        
        System.out.println(dist[end]);
        
        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while(current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        for(int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;
        
        while(!q.isEmpty()) {
            Node current = q.poll();
            
            if(!visited[current.e]) visited[current.e] = true;
            else continue;
            
            for(int i = 0; i < list[current.e].size(); i++) {
                Node next = list[current.e].get(i);
                if(dist[next.e] > dist[current.e] + next.cost) {
                    dist[next.e] = dist[current.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = current.e;
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int e;
        int cost;
        
        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}