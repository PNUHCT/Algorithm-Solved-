import java.io.*;
import java.util.*;

public class no1865 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, Node, Edge, WH;
    private static int INF = Integer.MAX_VALUE;
    private static StringTokenizer st, tempSt;
    private static int[] dist;
    private static ArrayList<ArrayList<Move>> map;

    public static void main(String[] args) throws IOException {
        // 각 테스트 케이스를 반복 실행
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) Search();

        bw.close(); // 최종 끝나는 지점
    }

    /**
     * 실제 각 테스트 케이스를 구하는 메소드
     */
    private static void Search() throws IOException {
        //각 테스트 케이스별 기본 지도 만드는 구간
        st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        WH = Integer.parseInt(st.nextToken());
        dist = new int[Node + 1];// start에서 출발하여 각 노드에 도착하는 최단거리를 업데이트하며 기록해줄 배열
        map = new ArrayList<>();
        for (int i = 0; i <= Node; i++) map.add(new ArrayList<>());

        initialize(); // 지도에 길/웜홀 설정 위임

        // 여기서부터 벨만포드 알고리즘을 통한 판별 구간
        boolean isMinusCircle = false; // 벨만포드에 아무것도 성립하지 않는 경우 체크용
        for(int i = 1; i <= Node; i++) {
            if(bellmanFord(i)) {  // 벨만포드 확인 후 minusCircle이 가능하다면,
                isMinusCircle = true;  // 아래 NO가 입력되는 부분을 제껴주기 위함
                bw.write("YES\n"); // YES입력 후 더이상 구할 필요 없으니 break;
                break;
            }
        }
        if(!isMinusCircle) bw.write("NO\n");
    }

    /**
     * 각 테스트케이스별 입력을 초기화해주는 메소드
     */
    private static void initialize() throws IOException {
        for (int i = 0; i < Edge; i++) {
            tempSt = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(tempSt.nextToken());
            int arrival = Integer.parseInt(tempSt.nextToken());
            int cost = Integer.parseInt(tempSt.nextToken());

            map.get(departure).add(new Move(arrival, cost));
            map.get(arrival).add(new Move(departure, cost));
        }
        for (int i = 0; i < WH; i++) {
            tempSt = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(tempSt.nextToken());
            int arrival = Integer.parseInt(tempSt.nextToken());
            int cost = Integer.parseInt(tempSt.nextToken()) * -1;
            map.get(departure).add(new Move(arrival, cost));
        }
    }

    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF); // start에서 출발하여 각 노드에 도착하는 최단거리를 업데이트하며 기록해줄 배열
        dist[start] = 0; // 시작점 초기화
        boolean update = false; // 최단거리가 업데이트 되는지 확인용

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복
        for(int i=1; i<Node ; i++) {
            update = false;

            for(int j=1 ; j<=Node ; j++) {
                for(Move move : map.get(j)) {
                    // INF가 아닌 경우를 충족시키기 위해 시작점을 0으로 초기화 한 것
                    // 기존에 저장된 최단거리보다, j번째에서 해당지점으로 새로이동하는 경우가 더 최단거리일 경우 작은값으로 업데이트
                    if(dist[j] != INF && dist[move.town] > dist[j] + move.sum) {
                        dist[move.town] = dist[j] + move.sum;
                        update = true;
                    }
                }
            }

            // 더이상 최단거리 업데이트가 이루어지지 않는 경우 멈춤
            if(!update) break;
        }

        if(update) {
            for(int i=1 ; i<=Node ; i++) { // 1 ~ Node번까지 모든 노드를 체크하기 위함
                for(Move move : map.get(i)) {
                    if(dist[i] != INF && dist[move.town] > dist[i] + move.sum) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    /**
     * 탐색을 위한 객체 클래스
     */
    private static class Move {
        private int town, sum;
        public Move(int town, int sum) {
            this.town = town;
            this.sum = sum;
        }
    }
}