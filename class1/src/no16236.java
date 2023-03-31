import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class no16236 {
    private static int T;
    private static int[][] Sea;
    private static int[] ver = {-1, 0, 0, 1};
    private static int[] hor = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int initY = 0;
        int initX = 0;
        T = Integer.parseInt(br.readLine()); // 맵의 사이즈
        Sea = new int[T][T];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < T; j++) {
                int temp = Integer.parseInt(st.nextToken());
                Sea[i][j] = temp;
                if (temp == 9) {
                    initY = i;
                    initX = j;
                    Sea[i][j] = 0;
                }
            }
        }

        System.out.println(BFS(initY, initX));
    }


    /**
     * BFS 방식
     * 탈출조건 : 큐가 비워질 때까지 먹이를 먹은 적이 없으면 반복문 탈출
     */
    private static int BFS(int initY, int initX) {
        Shark shark = new Shark(initY,initX,0); // 상어 객체로서, 대기열에서 나오는 애들을 순차적으로 할당해주며 업데이트 됨

        // 첫 시작 세팅
        int Level = 2;
        int Exp = 0; // 먹은 물고기 수
        int TotalDist = 0; // 움직인 총 거리

        while (true) {
            PriorityQueue<Shark> que = new PriorityQueue<>((a, b) ->
                    a.Count != b.Count ? Integer.compare(a.Count, b.Count) : (a.Y != b.Y ? Integer.compare(a.Y, b.Y) : Integer.compare(a.X, b.X)));
            boolean[][] visited = new boolean[T][T];

            que.add(new Shark(shark.Y, shark.X, 0)); // 상어 업데이트
            visited[shark.Y][shark.X] = true; // 방문체크

            boolean check = false; // 이번 레벨에 물고기 먹었는지 확인용

            while (!que.isEmpty()) {
                 shark = que.poll();

                 // 물고기 먹은 경우
                if (Sea[shark.Y][shark.X] != 0 && Sea[shark.Y][shark.X] < Level) {
                    Sea[shark.Y][shark.X] = 0;
                    Exp++;
                    TotalDist += shark.Count; // 이번 여정에 움직인 거리를 총 움직인 거리에 추가
                    check = true; // 먹었음
                    break; // 반복종료 (== 새로운 출발)
                }

                for (int move = 0; move < 4; move++) {
                    int nextY = shark.Y + ver[move];
                    int nextX = shark.X +hor[move];

                    // 범위를 벗어나지 않고, 방문한적 없고, 지나갈 수 있는 길일 때 -> 이동
                    if (nextY >= 0 && nextX >= 0 && nextX < T && nextY < T &&
                            !visited[nextY][nextX] && Sea[nextY][nextX] <= Level) {
                        que.add(new Shark(nextY, nextX, shark.Count + 1));
                        visited[nextY][nextX] = true;
                    }
                }
            }

            if (!check) break; // 이번 레벨에서 먹은게 없으면 탐색종료

            if (Level == Exp) { // 경험치가 레벨과 같다면 레벨업
                Level++;
                Exp = 0;
            }
        }

        return TotalDist;
    }

    /**
     * 아기상어 객체
     */
    private static class Shark {
        private int Y;
        private int X;
        private int Count; // 이동 거리

        public Shark(int y, int x, int count) {
            this.Y = y;
            this.X = x;
            this.Count = count;
        }
    }
}