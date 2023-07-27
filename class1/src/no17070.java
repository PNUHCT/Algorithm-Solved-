import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no17070 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static boolean[][] field;

    // 현재상태가 가로일 때
    private static int[] verWidth = {0, 1};
    private static int[] horWidth = {1, 1};

    // 현재 상태가 세로일 때
    private static int[] verLength = {1, 1};
    private static int[] horLength = {0, 1};

    // 현재 상태가 대각선일 때
    private static int[] verDiagonal = {0, 1, 1};
    private static int[] horDiagonal = {1, 0, 1};

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        field = new boolean[N+1][N+1];
        StringTokenizer st;

        for(int i = 1; i<= N; i++) {
           st = new StringTokenizer(br.readLine(), " ");
           for(int j=1 ; j<= N; j++) {
               if(st.nextToken().equals("1")) field[i][j] = true;
           }
        }

        field[1][1] = field[1][2] = true;

        int result = BFS();

        System.out.println(result);
    }

    private static int BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        // 처음은 무조건 가로이므로, 가로 방향에서 가능한 이동방식으로 초기화
        if(field[1][3]) return 0;

        if(field[2][2]) dq.add(new Node(1, 3, 0));
        else {
            for (int i = 0; i < horWidth.length; i++) {
                dq.add(new Node(1 + verWidth[i], 2 + horWidth[i], i)); // 가로 0 대각선 1
            }
        }

        int count = 0;

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            if(now.Y==N && now.X==N) count++;

            // 가로
            if(now.NodeType==0) {
                for(int i=0 ; i<verWidth.length ; i++) {
                    if(i==0) {  // 가로 이동
                        if(now.X+1<=N &&
                                !field[now.Y][now.X+1]) dq.add(new Node(now.Y + verWidth[i], now.X + horWidth[i], 0));
                    }
                    else { // 대각선 이동 - 조건 : 4칸이 true
                        if(now.Y+1<=N && now.X+1 <= N &&
                                !field[now.Y][now.X+1] && !field[now.Y+1][now.X] && !field[now.Y+1][now.X+1]) dq.add(new Node(now.Y + verWidth[i], now.X + horWidth[i], 1));
                    }
                }
            }
            // 대각선
            else if(now.NodeType==1) {
                for(int i=0 ; i<verDiagonal.length ; i++ ) {
                    if(i==0) { // 가로이동
                        if(now.X+1 <= N &&
                                !field[now.Y][now.X+1]) dq.add(new Node(now.Y + verDiagonal[i], now.X + horDiagonal[i], 0));
                    } else if (i==1) { // 세로이동
                        if(now.Y+1<=N &&
                                !field[now.Y+1][now.X]) dq.add(new Node(now.Y + verDiagonal[i], now.X + horDiagonal[i], 2));
                    } else { // 대각선 이동
                        if(now.Y+1<=N && now.X+1 <= N &&
                                !field[now.Y][now.X+1] && !field[now.Y+1][now.X] && !field[now.Y+1][now.X+1]) dq.add(new Node(now.Y + verDiagonal[i], now.X + horDiagonal[i], 1));
                    }
                }
            }
            // 세로
            else {
                for(int i=0 ; i<verLength.length ; i++) {
                    if(i==0) {  // 세로 이동
                        if(now.Y+1 <= N &&
                                !field[now.Y+1][now.X]) dq.add(new Node(now.Y + verLength[i], now.X + horLength[i], 2));
                    }
                    else { // 대각선 이동 - 조건 : 4칸이 true
                        if(now.Y+1<=N && now.X+1 <= N &&
                                !field[now.Y][now.X+1] && !field[now.Y+1][now.X] && !field[now.Y+1][now.X+1]) dq.add(new Node(now.Y + verLength[i], now.X + horLength[i], 1));
                    }
                }
            }
        }
        return count;
    }

    private static class Node {
        private int Y, X, NodeType;

        private enum NodeType {
            width, diagonal, length   // 0, 1, 2
        }

        public Node(int y, int x, int nodeType) {
            this.Y = y;
            this.X = x;
            this.NodeType = nodeType;
        }
    }
}