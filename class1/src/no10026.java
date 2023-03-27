import java.io.*;
import java.util.*;

public class no10026 {
    private static int T;  // BFS에서 탐색할 범위 제한을 위해 static 선언
    private static String[][] normalMap; // 탐색할 맵
    private static String[][] weakMap; // 탐색할 맵
    private static boolean normalVisit[][]; // 일반인 기준 방문판정용
    private static boolean weakVisit[][];  // 색약인 기준 방문판정용
    private static int normalCnt = 0;  // 일반인 기준 총 블록수 count
    private static int weakCnt = 0;  // 색약인 기준 퐁 블록수 count
    private static int[] ver = {-1, 1, 0, 0};  // 종이동 만들어주는 용도
    private static int[] hor = {0, 0, -1, 1};  // 횡이동 만들어주는 용도

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();

        T = Integer.parseInt(br.readLine());
        normalMap = new String[T][T];
        weakMap = new String[T][T];
        normalVisit = new boolean[T][T];
        weakVisit = new boolean[T][T];

        // 맵 초기화
        for(int y=0; y<T ; y++) {
            String[] colorArr = br.readLine().split("");
            for(int x=0; x<T; x++) {
                String color = colorArr[x]; // 원래 색상을 입력받음
                normalMap[y][x] = color;
                if(color.equals("R")) color = "G"; // 만약 색상이 R이면, G로 변환해줌(R로 하나 G로 하나 상관없음)
                weakMap[y][x] = color; // 변환된 색상 입력
            }
        }

        for(int y=0; y<T; y++) {
            for(int x=0; x<T; x++) {
                if(!normalVisit[y][x]) normalBFS(y,x);
                if(!weakVisit[y][x]) weakBFS(y,x);
            }
        }

        System.out.println(sb.append(normalCnt).append(" ").append(weakCnt));
    }

    /**
     * RGB 탐색
     */
    private static void normalBFS(int y, int x) {
        Deque<Color> dq = new ArrayDeque<>();
        dq.add(new Color(y,x));
        normalVisit[y][x] = true;
        String nowColor = normalMap[y][x]; // 각 탐색별 기준이 될 컬러(RGB)
        normalCnt++; // 만약 각 컬러를 다르게 구하고 싶으면, 여기서 색상별로 count 구분해서 count 가능

        while(!dq.isEmpty()) {
            Color now = dq.poll();

            for(int move = 0 ; move < 4 ; move++) {
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];
                // 맵의 범위를 벗어나지 않고, 방문한 적이 없고, 이동할 위치가 기준 색상과 같은 경우
                if(0<=nextY && nextY<T && 0<=nextX && nextX<T
                        && !normalVisit[nextY][nextX]
                        && normalMap[nextY][nextX].equals(nowColor)) {
                    normalVisit[nextY][nextX] = true;
                    dq.add(new Color(nextY, nextX));
                }
            }
        }
    }

    /**
     * GB 탐색
     */
    private static void weakBFS(int y, int x) {
        Deque<Color> dq = new ArrayDeque<>();
        dq.add(new Color(y,x));
        weakVisit[y][x] = true;
        String nowColor = weakMap[y][x]; // 각 탐색별 기준이 될 컬러(GB)
        weakCnt++; // 만약 각 컬러를 다르게 구하고 싶으면, 여기서 색상별로 count 구분해서 count 가능

        while(!dq.isEmpty()) {
            Color now = dq.poll();

            for(int move = 0 ; move < 4 ; move++) {
                int nextY = now.Y + ver[move];
                int nextX = now.X + hor[move];
                // 맵의 범위를 벗어나지 않고, 방문한 적이 없고, 이동할 위치가 기준 색상과 같은 경우
                if(0<=nextY && nextY<T && 0<=nextX && nextX<T
                        && !weakVisit[nextY][nextX]
                        && weakMap[nextY][nextX].equals(nowColor)) {
                    weakVisit[nextY][nextX] = true;
                    dq.add(new Color(nextY, nextX));
                }
            }
        }
    }

    /**
     * 좌표를 받아줄 객체 클래스
     */
    private static class Color {
        private int Y;
        private int X;
        public Color(int y, int x) {
            this.Y = y;
            this.X = x;
        }
    }
}

