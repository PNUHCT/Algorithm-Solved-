import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no1074 {

    /**
     * 결과를 카운트 해줄 변수
     */
    private static int count;

    /**
     * 입력, 실행 및 출력을 담당하는 main메소드
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int Length = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        Quad(X, Y , Length);

        System.out.println(count);
    }

    /**
     * 실질적으로 값을 계산해주는 로직이 담긴 메소드
     * @param X,Y : 주어진 최초의 지점의 위치
     * @param Length : 주어진 최초의 이중배열의 길이
     */
    private static void Quad(int X, int Y, int Length) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(X,Y,Length));  // 첫번째 계산을 위함

        // 1이 되기 전까지 대기열에 계산해줄 값이 Node 객체 형식으로 담길거임
        while(!dq.isEmpty()) {
            Node now = dq.poll();
            int nowX = now.X;
            int nowY = now.Y;
            int nowL = now.L;

            // 1이면 마지막 지점이므로 더이상 대기열에 넣지 않음
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

