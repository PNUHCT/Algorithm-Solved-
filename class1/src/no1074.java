import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no1074 {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 분할정복
         * 1. 주어진 길이를 2등분 하여 배열을 4등분한다
         * 2. 주어진 정점이 1사분면에 있다면 다시 4분할
         * 3. 주어진 정점이 2사분면에 있다면 1사분면을 count++ 해주고 다시 4분할
         * 4. 주어진 정점이 3사분면에 있다면 1,2사분면을 count++ 해주고 다시 4분할
         * 5. 주어진 정점이 4사분면에 있다면 1,2,3사분면을 count++ 해주고 다시 4분할
         * 6. 길이가 1이 될 때까지 4분할 진행
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int Length = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Quad(X, Y , Length);

        System.out.println(count);
    }

    private static void Quad(int X, int Y, int Length) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(X,Y,Length));  // 첫번째 계산을 위함

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            int nowX = now.X;
            int nowY = now.Y;
            int nowL = now.L;

            // 1이면 마지막 지점이므로 멈춤
            if(nowL!=1) {
                // 1 사분면
                if (nowX < nowL/2 && nowY < nowL/2) {
                    dq.add(new Node(nowX, nowY, nowL/2));
                }
                // 2 사분면
                else if (nowX < nowL/2 && nowY >= nowL/2) {
                    count += ((nowL/2) * (nowL/2));
                    dq.add(new Node(nowX, nowY-nowL / 2, nowL/2));
                }
                // 3 사분면
                else if (nowX >= nowL / 2 && nowY < nowL / 2) {
                    count += ((nowL/2) * (nowL/2)) * 2;
                    dq.add(new Node(nowX-nowL / 2, nowY, nowL / 2));
                }
                // 4 사분면
                else {
                    count += ((nowL/2) * (nowL/2)) * 3;
                    dq.add(new Node(nowX-nowL/2, nowY-nowL/2, nowL/2));
                }
            }
        }
    }

    private static class Node {
        private int X;
        private int Y;
        private int L;
        public Node(int x, int y, int L) {
            this.X = x;
            this.Y = y;
            this.L = L;
        }
    }
}

