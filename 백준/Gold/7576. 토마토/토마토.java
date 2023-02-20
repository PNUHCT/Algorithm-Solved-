import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    /**
     * 1. 처음 입력때 0의 개수 파악
     * 2. 만약 0이 없으면  바로 0을 출력(처음부터 모두 익은상태)
     * 3. 반복을 하면서 1이 있는 위치의 상하좌우에 0이 있으면 1로 바꾸고 바뀌는 개수만큼 count, 1회 반복당 count+1, 바꾼 개수만큼 0의 개수에서 빼줌
     * 4. 만약 1로 바뀌는 개수가 0인데, 0의 개수가 0보다 크면 더이상 못바꾸는 경우이므로 -1 출력
     */

    static int M;
    static int N;
    static int zero;
    static int[][] box;
    static int[] horizontal = {1, -1, 0, 0};
    static int[] vertical = {0, 0, 1, -1};

    public static class Tomato {
        private int x;
        private int y;
        private int day;
        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        for(int i=0; i<M ; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) {
                int tomato = Integer.parseInt(line.nextToken());
                box[i][j] = tomato;
                if(tomato==0) zero++;
            }
        }
        if(zero==0) System.out.println(0);
        else System.out.println(BFS());
    }

    private static int BFS() {
        Deque<Tomato> dq = new ArrayDeque<>(); // 검수할 토마토 위치를 담는 대기열
        int day = 0;  // 최종 반환 값

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(box[i][j]==1) dq.add(new Tomato(i,j, 0));
            }
        }

        /**
         * BFS 반복 시작
         */
        while(!dq.isEmpty()) {
            Tomato now = dq.poll();
            day= now.day; // 매 4방향 반복마다 +1의 데이가 Tomato 객체 안에 쌓임

            for(int i=0 ; i<4 ; i++) {
                int nowX = now.x + horizontal[i]; // 천잰데??
                int nowY = now.y + vertical[i];  // 0~3반복하는동안 각각 X축 Y축으로 +1과 -1로 상하좌우 도는 방법

                if(0<=nowX && nowX<M && 0<=nowY && nowY<N) {  // box 범위 내일 때
                    if(box[nowX][nowY]==0) {
                        box[nowX][nowY] = 1;
                        dq.add(new Tomato(nowX, nowY, day+1));
                        zero--;
                    }
                }
            }
        }

        // 만약 box에 0이 남아있는 경우
        if(zero!=0) day= -1;

        return day;
    }
}