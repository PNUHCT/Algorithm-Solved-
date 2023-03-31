import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /**
     * 0. 처음 아기상어의 크기는 2
     * 1. 아기상어는 자기보다 작은 숫자의 물고기만 잡아먹을 수 있음 (같은 숫자 안됨)
     * 2. 아기상어는 자기와 같거나 작은 숫자의 칸은 지나갈 수 있음
     * 3. 아기상어는 자기와 같은 수만큼 물고기를 잡아먹으면 레벨업
     * 4. 만약 잡아먹을게 많으면 가장 가까운 놈부터
     * 5. 만약 같은 거리면, 위에 있는 애부터 (매트릭스 탐색시, y=0 ; y<T ; y++ 라는 소리)
     * 6. 만약 전부 다 위에 있는 같은 거리면, 왼쪽부터 (매트릭스 탐색시, x=0 ; x<T ; x++ 라는 소리)
     */

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
        /**
         * 1. 잡아 먹을때까지 반복 -> 큐가 비워질 때까지 잡아먹은 게 없으면 탈출
         * 2. 방문한적 없으면서 0이거나, 방문한 적 없으면서 같은 숫자면 그냥 통과
         * 3. 잡아먹으면, 0으로 바꾸고, result에 이동거리 저장하고, 큐 flush하고, 레벨보다 낮은 숫자는 방문 해제
         */
        Shark shark = new Shark(initY,initX,0);
        // 첫 시작 세팅
        int Level = 2;
        int Exp = 0; // 먹은 물고기 수
        int TotalDist = 0; // 움직인 총 거리

        while (true) {
            PriorityQueue<Shark> que = new PriorityQueue<>((a, b) ->
                    a.Count != b.Count ? Integer.compare(a.Count, b.Count) : (a.Y != b.Y ? Integer.compare(a.Y, b.Y) : Integer.compare(a.X, b.X))
            );
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