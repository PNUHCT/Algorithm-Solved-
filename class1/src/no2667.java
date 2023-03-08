import java.io.*;
import java.util.*;

public class no2667 {

    private static int[] ver = {-1, 1, 0, 0};  // 종횡 좌표 이동용 (BFS에서 사용)
    private static int[] hor = {0, 0, -1, 1};  // 횡행 좌표 이동용 (BFS에서 사용)
    private static int[][] map;
    private static boolean[][] visited;  // 방문체크용
    private static int N;  // 사이즈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * Input 초기화 단계
         */
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < N; j++) map[i][j] = Integer.parseInt(arr[j]);
        }

        /**
         * BFS 호출 단계 : map 의 각 지점 중 1인 지점에 한해서, 방문한 적이 없는 지점을 시작으로 BFS 수행하는 방식
         */
        for (int Y = 0; Y < N; Y++) {
            for (int X = 0; X < N; X++) {
                if (map[Y][X] == 1 && !visited[Y][X]) {
                    visited[Y][X] = true;  // 최초 지점 방문체크 필수 : 안하면 BFS 에서 최초지점 중복 탐색이 됨
                    result.add(BFS(Y, X)); // 각 단지의 사이즈를 list 에 모음
                }
            }
        }

        /**
         * Output 만드는 단계
         * 오름차순 정렬 (내림차순은 reverseOrder()).
         * * Comparator를 호출하면, 시용하던 list를 그대로 사용해도 정렬이 된다.
         * * 만약 Collection이나 stream().sorted()를 사용하면, list 를 새로운 sortedList 객체로 할당 해줘야 한다.
         */
        result.sort(Comparator.naturalOrder());
        bw.write(""+result.size()+"\n");  // 총 단지 수 담고
        for(int anw : result) bw.write(""+anw +"\n");  // 각 단지의 사이즈 담는다

        bw.close();
    }

    private static int BFS(int i, int j) {
        Deque<Node> dq = new ArrayDeque<>();  // ArrayDeque가 처리속도가 빠르다
        dq.add(new Node(i, j));  // 최초 지점
        int count = 1;  // 최초지점을 카운트 (만약 0으로 초기화 하고 싶을 경우, 아래 while 문에서, if 문에서 dq.add()할 때 말고, dq.poll()할때 count 하는 방식으로 하면 된다.

        while (!dq.isEmpty()) {
            Node now = dq.poll();
            for (int dir = 0; dir < 4; dir++) {
                int nowY = now.Y + ver[dir];
                int nowX = now.X + hor[dir];
                if (0 <= nowY && nowY < N && 0 <= nowX && nowX < N && !visited[nowY][nowX]) {
                    if(map[nowY][nowX]==1) {
                        dq.add(new Node(nowY, nowX));
                        visited[nowY][nowX] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * 객체 방식 사용
     */
    private static class Node {
        private int Y;
        private int X;
        public Node(int y, int x) {
            this.Y = y;
            this.X = x;
        }
    }
}

