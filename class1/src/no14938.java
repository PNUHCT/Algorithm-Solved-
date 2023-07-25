import java.io.*;
import java.util.*;

public class no14938 {
//    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    private static int Node, Edge, Availability;
//    private static StringTokenizer st;
//    private static int[] item_status;
//    private static Integer[][] field_map; // 길이 없으면 Null
//    private static boolean[][] visited;
//
//    public static void main(String[] args) throws IOException {
//        // 첫 줄 입력 (지점 수, 능력치, 길 수)
//        st = new StringTokenizer(br.readLine(), " ");
//        Node = Integer.parseInt(st.nextToken());
//        Availability = Integer.parseInt(st.nextToken());
//        Edge = Integer.parseInt(st.nextToken());
//
//        // 각 지점별 아이템 수 저장
//        st = new StringTokenizer(br.readLine(), " ");
//        item_status = new int[Node];
//        for (int i = 0; i < Node; i++) item_status[i] = Integer.parseInt(st.nextToken());
//
//        // 길 연결
//        field_map = new Integer[Node][Node];
//        int A, B, Cost;
//        for (int i = 0; i < Edge; i++) {
//            st = new StringTokenizer(br.readLine(), " ");
//            A = Integer.parseInt(st.nextToken()) - 1;
//            B = Integer.parseInt(st.nextToken()) - 1;
//            Cost = Integer.parseInt(st.nextToken());
//            field_map[A][B] = field_map[B][A] = Cost;
//        }
//
//        int result = 0;
//        for (int departure = 0; departure < Node; departure++) {
//            result = Math.max(result, BFS(departure));
//        }
//
//        System.out.println(result);
//    }
//
//    private static int BFS(int departure) {
//        int result = item_status[departure]; // 처음 내린 지점의 아이템 수
//        Deque<Region> dq = new ArrayDeque<>();
//        visited = new boolean[Node][Node]; // 각 탐색별로 체크용도
//        dq.add(new Region(departure, 0)); // 처음 내린 지점, 이동거리 0
//
//        while (!dq.isEmpty()) {
//            Region now = dq.poll();
//
//            for (int i = 0; i < Node; i++) {
//                if (field_map[now.start][i] == null) continue; // 이동이 불가능한 곳이라면 패스하고 다음지점 탐색
//
//                // 다음 지점으로 이동 가능한 여력이 있을 때
//                if (!visited[now.start][i]) {
//                    int next_move = now.move + field_map[now.start][i];
//
//                    if (next_move <= Availability) {
//                        visited[now.start][i] = true; // 다음 이동 지점 방문 체크
//                        result += item_status[i]; // 이동해서 파밍
//                        dq.add(new Region(i, next_move)); // 다음지점 탐색, 누적 이동거리
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    // BFS를 위한 객체용 클래스
//    private static class Region {
//        private int start, move;
//
//        public Region(int start, int move) {
//            this.start = start;
//            this.move = move;
//        }
//    }
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