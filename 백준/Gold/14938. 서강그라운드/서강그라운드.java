import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, R; // 지역 수, 가능한 수색 능력, 길의 수
    private static int[] item_status; // 각 지역별 아이템 수
    private static ArrayList<ArrayList<Region>> field;
    private static int[] dist; // 최단거리 배열
    private static boolean[] visited; // 방문확인
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 각 지역별 아이템 수 입력
        item_status = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=N ; i++) item_status[i] = Integer.parseInt(st.nextToken());

        // 각 루트별 비용 입력 (양방향)
        field = new ArrayList<>();
        for(int i=0 ; i<=N ; i++) field.add(new ArrayList<>());
        for(int i=1 ; i<=R ; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            field.get(start).add(new Region(end, cost));
            field.get(end).add(new Region(start, cost));
        }

        dist = new int[N+1];
        visited = new boolean[N+1];

        int result = 0;
        for(int i=1; i<=N ; i++) result = Math.max(result, dijkstra(i));

        bw.write(result + "\n");
        bw.close();    }

    private static int dijkstra(int start) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        PriorityQueue<Region> pq = new PriorityQueue<>();
        pq.add(new Region(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Region now = pq.poll();
            int nowNo = now.regionNo;

            if(!visited[nowNo]) {
                visited[nowNo] = true;

                for(Region region : field.get(nowNo)) {
                    if(!visited[region.regionNo] && dist[region.regionNo] > dist[nowNo] + region.cost) {
                        dist[region.regionNo] = dist[nowNo] + region.cost;
                        pq.add(new Region(region.regionNo, dist[region.regionNo]));
                    }
                }
            }
        }

        int response = 0;
        for(int i=1 ; i<=N ; i++) if(dist[i]<=M) response += item_status[i];

        return response;

    }
}

class Region implements Comparable<Region> {
    int regionNo, cost;

    Region(int regionNo, int cost) {
        this.regionNo = regionNo;
        this.cost = cost;
    }

    @Override
    public int compareTo (Region reg) {
        return cost - reg.cost;
    }
}