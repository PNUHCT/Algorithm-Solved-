import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no1865 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, Node, Edge, WH;
    private static StringTokenizer st, tempSt;
    private static int[][] map;
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
            int cost = Integer.parseInt(tempSt.nextToken());
            map[departure][arrival] = cost;
        }
    }

    private static void BFS(int start) throws IOException {
        /**
         * 1. DFS를 이용해 출발 노드로부터 출발노드로 도착하는 경우 탐색
         * 2. 도착하면 재귀종료
         * 3. 만약 중간에 -값 나오면 재귀 종료 후 cost 반환
         * 4.
         */
    }
}

