import java.io.*;
import java.util.*;

public class no1149 {

    /**
     * 순서대로 RGB를 칠하는 방법 중 최소비용을 구하기
     * Input : 빨강 초록 파랑 순으로 비용이 주어진다.
     * Output : 총 비용 중 최소합 구하기
     * 단, 양옆으로는 현재 색과 다른 색이어야 한다.
     *
     * https://www.acmicpc.net/problem/1149
     */

//    private static List<Integer> results = new ArrayList<>();
//    private static int T;
//    private static int[][] map;
//    private static String[] firstRGB = {"R", "G", "B"};
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        T = Integer.parseInt(br.readLine());
//        map = new int[T][3];
//        for(int i=0; i<T ; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//            map[i][0] = Integer.parseInt(st.nextToken());
//            map[i][1] = Integer.parseInt(st.nextToken());
//            map[i][2] = Integer.parseInt(st.nextToken());
//        }
//
//        for(int i=0; i<3; i++) {
//            Check now = new Check(map[0][i], firstRGB[i], 0);
//            recur(now);
//        }
//
//        int result = Collections.min(results);
//        System.out.println(result);
//    }
//
//
//    private static void recur (Check now) {
//        if(now.Order==T-1) results.add(now.Sum);
//        else {
//            if(now.RGB.equals("R")) {
//                recur(new Check(now.Sum + map[now.Order+1][1], "G", now.Order+1));
//                recur(new Check(now.Sum + map[now.Order+1][2], "B", now.Order+1));
//            }
//            else if (now.RGB.equals("G")) {
//                recur(new Check(now.Sum + map[now.Order+1][0], "R", now.Order+1));
//                recur(new Check(now.Sum + map[now.Order+1][2], "B", now.Order+1));
//            }
//            else {
//                recur(new Check(now.Sum + map[now.Order+1][0], "R", now.Order+1));
//                recur(new Check(now.Sum + map[now.Order+1][1], "G", now.Order+1));
//            }
//        }
//    }
//
//    private static class Check {
//        private int Sum;
//        private String RGB;
//        private int Order;
//
//        public Check (int sum, String rgb, int order) {
//            this.Sum = sum;
//            this.RGB = rgb;
//            this.Order = order;
//        }
//    }

    final static int R = 0;
    final static int G = 1;
    final static int B = 2;
    static int[][] map;
    static int[][] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][3];
        DP = new int[N][3];

        StringTokenizer st;
        for(int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            map[i][R] = Integer.parseInt(st.nextToken());
            map[i][G] = Integer.parseInt(st.nextToken());
            map[i][B] = Integer.parseInt(st.nextToken());
        }

        DP[0][R] = map[0][R];
        DP[0][G] = map[0][G];
        DP[0][B] = map[0][B];


        System.out.println(Math.min(recur(N- 1, R), Math.min(recur(N - 1, G), recur(N - 1, B))));
    }

    static int recur(int N, int color) {
        if(DP[N][color] == 0) {

            if(color == R) {
                DP[N][R] = Math.min(recur(N - 1, G), recur(N - 1, B)) + map[N][R];
            }
            else if(color == G) {
                DP[N][G] = Math.min(recur(N - 1, R), recur(N - 1, B)) + map[N][G];
            }
            else {
                DP[N][B] = Math.min(recur(N - 1, R), recur(N - 1, G)) + map[N][B];
            }

        }
        return DP[N][color];
    }
}