import java.io.*;
import java.util.*;

public class no1987 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int R, C;
    private static String[][] map;
    private static Set<String> initSet = new HashSet<>();
    private static final int[] ver = {-1, 1, 0, 0};
    private static final int[] hor = {0, 0, -1 ,1};

    /**
     * 1. 주어진 R * C 크기의 String Map
     * 2. 중복 금지 (ArrayList로 체크? Map사용?)
     * 3. 최대 거리 다익스트라
     */

    public static void main(String[] args) throws IOException {
        // 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new String[R][C];

        for(int i=0;i<R;i++) map[i] = br.readLine().split("");

        // 처음에 모든 알파벳을 Set에 저장해 두는 작업. 아스키 코드를 이용한 반복문 사용.
        for(int i=17 ; i<40 ; i++) {
            char temp = '0';
            temp += i;
            initSet.add(String.valueOf(temp));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra () {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.Cnt - a.Cnt);
        initSet.remove(map[0][0]); // 첫 칸은 제외
        pq.add(new Node(0,0,1, initSet)); // 첫 칸부터 탐색 시작
        int max = 1; // 최소 1칸은 이동

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            // 좌표 이동을 위한 반복문
            for(int move=0 ; move<4 ; move++) {
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];

                if(nextY<0 || nextX<0 || nextY >=R || nextX >= C) continue; // 맵을 벗어나면 패스

                if(!now.ChaSet.contains(map[nextY][nextX])) max = Math.max(max, now.Cnt); // 중복이 발생하는 이동마다 이동거리 비교

                else { // 이동 가능하다면 이동, 이동한 칸의 알파벳은 Set에서 제외
                    Set<String> nextSet = new HashSet<>(Set.copyOf(now.ChaSet));
                    nextSet.remove(map[nextY][nextX]);
                    pq.add(new Node(nextY, nextX, now.Cnt + 1, nextSet));
                }
            }
        }
        return max; // 이동 가능한 최대 거리를 반환
    }

    private static class Node {
        private int Y, X, Cnt;
        private Set<String> ChaSet;
        public Node(int y, int x, int cnt, Set<String> chaSet) {
            this.Y = y;
            this.X = x;
            this.Cnt = cnt;
            this.ChaSet = chaSet;
        }
    }
}