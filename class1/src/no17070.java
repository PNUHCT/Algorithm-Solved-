import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;


/**
 * 문제 링크
 * https://www.acmicpc.net/problem/17070
 *
 * 조건
 * 1. 파이프는 무조건 두 칸을 차지한다
 * 2. 첫 파이프는 항상 (1,1)(1,2)에 걸쳐있다 (길이가 2칸인 파이프)
 * 3. 파이프의 이동은 다음의 이동만 가능하다.
 *    가로일 때, 가로 or 오른쪽아래대각선
 *    세로일 때, 세로 or 오른쪽아래대각선
 *    대각선일 때, 가로 or 세로 or 오른쪽아래대각선
 * 4. 목표하는 N,N까지 이동이 가능한 경우의 수를 구해야 한다.
 * 5. 단, 중간에 이동이 불가능한 1인 칸이 있다면, 해당 경로는 지나칠 수 없다.
 * 6. 만약 대각선 이등을 해야한다면, 총 네칸을 차지한다.
 *
 * Input
 * 1. 사이즈 N
 * 2. 맵 현황 (0은 이동가느한 빈칸, 1은 이동불가한 벽)
 */

public class no17070 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1; i<= N; i++) {
           for(int j=1 ; j<= N; j++) {
               if(st.nextToken().equals("1")) field[i][j] = true;
           }
        }

        field[1][1] = field[1][2] = true;

        bw.close();
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        // 처음은 무조건 가로이므로, 가로 방향에서 가능한 이동방식으로 초기화
        for(int i=0 ; i<horWidth.length ; i++) {
            dq.add(new Node(1+verWidth[i], 2+horWidth[i], i)); // 가로 0 대각선 1
        }

        /**
         * 1. dq를 반복하며,
         * 2. 이전 상태가 가로일 때, 가로 조건으로 돌아
         * 3. 이전 상태가 세로일 때, 세로 조건으로 돌아
         * 4. 이전 상태가 대각선일 때, 대각선 조건으로 돌아
         */

        while (!dq.isEmpty()) {
            Node now = dq.poll();

            // 가로
            if(now.NodeType==0) {
                for(int i=0 ; i<verWidth.length ; i++) {

                }
            }
            // 대각선
            else if(now.NodeType==1) {

            }
            // 세로
            else {

            }

        }
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

