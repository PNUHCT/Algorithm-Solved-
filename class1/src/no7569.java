import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no7569 {

    /**
     * 1. BFS를 이용해 탐색
     * 2. 상하좌우앞뒤를 탐색
     * 3. 0의 개수를 처음에 count 해서 모든 탐색이 끝난 뒤 남아있으면 -1 리턴
     */

    private static int[][][] box; // 입력받은 토마토를 담은 삼중 배열
    private static boolean[][][] visited;  // 방문체크를 위한 삼중 배열
    private static Deque<Tomato> dq = new ArrayDeque<>(); // 익은 토마토를 넣어둘 대기열
    private static int[] level = {-1,1,0,0,0,0}; // 박스 단위 확인을 위해 위치 변경을 만들어줄 배열
    private static int[] ver = {0,0,-1,1,0,0}; // 한 박스에서 수직이동을 만들어줄 배열
    private static int[] hor = {0,0,0,0,-1,1}; // 한 박스에서 수평이동을 만들어줄 배열
    private static int M; // 박스의 가로
    private static int N; // 박스의 세로
    private static int H; // 몇번째 박스인지
    private static int check0 = 0; // 안익은 토마토 수를 체크해줄 변수
    private static int days=0; // 가장 마지막에 익은 날짜를 할당해줄 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 박스 초기화
        for(int z=0; z<H ; z++) {  // 높이 1의 짝 단위의 박스를 쌓는 구간
            for(int y=0 ; y<N ; y++) {  // 한 짝의 박스 안에 있는 토마토를 확인하기 위한 구간. 즉, z번의 반복 * y번의 반복만큼 다음 행을 읽어 StringTokenizer를 소환하는 방식
                StringTokenizer tempSt = new StringTokenizer(br.readLine(), " ");
                for(int x=0 ; x<M ; x++) {  // 한 짝의 박스를 실질적으로 확인하는 구간
                    int temp = Integer.parseInt(tempSt.nextToken()); // 현재 칸의 익은 혹은 안익은 토마토 유무 (-1 || 0 || 1)
                    box[z][y][x] = temp; // box에 토마토 상태를 넣어주고
                    if(temp==0) check0++; // 해당칸이 0이면 안익은 토마토 수 추가해주고
                    if(temp==1) {  // 1이면 탐색대상이므로 대기열에 넣어놓고, 이미 익었으므로 방문체크 해줌
                        dq.add(new Tomato(z, y, x, 0));
                        visited[z][y][x]= true;
                    }
                }
            }
        }

        BFS(); // 탐색 시작

        if(check0 !=0) System.out.println(-1); // 모든 탐색 후 안익은 토마토가 남아 있는 경우 -1 출력
        else System.out.println(days); // 모두 익은 경우, 가장 최근에 토마토가 익은 날짜를 출력
    }

    /**
     * box를 탐색하면서 각 칸을 확인해서 토마토의 상태를 확인하고, 익히면서 날짜를 세어줄 메소드
     */
    private static void BFS() {
        // 이미 처음에 익어있는 토마토들이 들어있는 상태로 시작
        while(!dq.isEmpty()) {
            Tomato now = dq.poll();
            if(now.Day>=days) days = now.Day; // 현재 토마토가 익은 날짜가 최근에 다른 토마토가 익은 날짜보다 나중이면, 최신화 시켜줌

            for(int k=0 ; k<6 ; k++) {
                int nextZ = now.Z + level[k];
                int nextY = now.Y + ver[k];
                int nextX = now.X + hor[k];

                if(0<=nextZ && nextZ<H && 0<=nextY && nextY<N && 0<=nextX && nextX<M && !visited[nextZ][nextY][nextX]) {
                    // 안익은 토마토를 익혀주는 부분
                    if(box[nextZ][nextY][nextX]==0) {
                        check0--;
                        dq.add(new Tomato(nextZ, nextY, nextX, now.Day+1));
                        visited[nextZ][nextY][nextX] = true;
                    }
                    // 빈 공간인 경우, 재방문 하지 않도록 방문체크만 해줌
                    else if (box[nextZ][nextY][nextX]==-1) visited[nextZ][nextY][nextX] = true;
                }
            }
        }
    }

    /**
     * 토마토의 위치와 익은 날짜를 받아줄 객체 클래스
     */
    private static class Tomato {
        private int Z;
        private int Y;
        private int X;
        private int Day; // 해당 토마토가 익은 날짜 (Deque에 들어가면서 자동으로 +1day)
        public Tomato(int z, int y, int x, int day) {
            this.Z = z;
            this.Y = y;
            this.X = x;
            this.Day= day;
        }
    }
}