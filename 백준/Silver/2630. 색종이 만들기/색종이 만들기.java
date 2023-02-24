import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    private static int[][] map;
    private static int T;
    private static int white;
    private static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        map = new int[T][T];
        for(int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<T;j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        BFS();

        System.out.println(white);
        System.out.println(blue);
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        Node first = new Node(0,0, T);
        dq.add(first);

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            int nowX = now.X;
            int nowY = now.Y;
            int start = map[nowX][nowY];
            int howMany = now.Length;
            boolean stop = false;
            for(int i = 0; i < howMany; i++) {
                for(int j = 0; j < howMany; j++) {
                    if(map[nowX+i][nowY+j]!=start) {
                        dq.add(new Node(nowX, nowY, howMany / 2));
                        dq.add(new Node(nowX + howMany / 2, nowY, howMany / 2));
                        dq.add(new Node(nowX, nowY + howMany / 2, howMany / 2));
                        dq.add(new Node(nowX + howMany / 2, nowY + howMany / 2, howMany / 2));
                        stop = true;
                        break;
                    }
                }
                if(stop) break;
            }
            if(!stop) {
                if (start == 0) white++;
                else blue++;
            }
        }
    }

    private static class Node {
        private int X;
        private int Y;
        private int Length;
        public Node(int x, int y, int length) {
            this.X = x;
            this.Y = y;
            this.Length = length;
        }
    }
}