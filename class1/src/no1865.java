import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no1865 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, Node, Edge, WH;
    private static StringTokenizer st, tempSt;
    private static int[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            Search();
        }

        bw.close();
    }


    private static void Search() throws IOException {
        st = new StringTokenizer(br.readLine());
        Node = Integer.parseInt(st.nextToken());
        Edge = Integer.parseInt(st.nextToken());
        WH = Integer.parseInt(st.nextToken());

        map = new int[Node+1][Node+1];
        initialize();

        System.out.println("initializing");

        for(int i=1 ; i<=Node ; i++) {
            BFS(i);
        }

    }

    private static void initialize() throws IOException {
        for(int i = 0 ; i < Edge ; i++) {
            tempSt = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(tempSt.nextToken());
            int arrival = Integer.parseInt(tempSt.nextToken());
            int cost = Integer.parseInt(tempSt.nextToken());
            map[departure][arrival] = map[arrival][departure] = cost;
        }
        for(int i = 0 ; i < WH ; i++) {
            tempSt = new StringTokenizer(br.readLine());
            int departure = Integer.parseInt(tempSt.nextToken());
            int arrival = Integer.parseInt(tempSt.nextToken());
            int cost = Integer.parseInt(tempSt.nextToken()) * -1;
            map[departure][arrival] = cost;
        }
    }

    /**
     * 이니셜라이징은 문제 X
     * BFS가 문제
     */
    private static void BFS(int start) throws IOException {
        Deque<Move> dq = new ArrayDeque<>();
        visited = new boolean[Node+1][Node+1];
        visited[start][start] = true;
        dq.add(new Move(start, 0));
        boolean YorN = false;
        /**
         * 1. DFS를 이용해 출발 노드로부터 출발노드로 도착하는 경우 탐색
         * 2. 도착하면 재귀종료
         * 3. 만약 중간에 -값 나오면 재귀 종료 후 cost 반환
         * 4.
         */
        while(!dq.isEmpty()) {
            Move now = dq.poll();
            if(now.town == start) {
                // 출발점에 도달한 뒤 시간역행한 경우
                if (now.sum < 0) YorN = true;
                // 출발지점에 돌아왔으나 시간역행은 실패한 경우는 별다른 처리 없음
                // 출발지점에 도착만 했다면 break;
                break;
            }

            for(int next = 1 ; next <= Node ; next++) {
                if(map[now.town][next]==0) continue;
                if(!visited[now.town][next]) {
                    visited[now.town][next] = true;
                    dq.add(new Move(next, now.sum + map[now.town][next]));
                }
            }
        }

        if (YorN) bw.write("YES\n");
        else bw.write("NO\n");
    }

    private static class Move {
        private int town, sum;
        public Move(int town, int sum) {
            this.town = town;
            this.sum = sum;
        }
    }
}

