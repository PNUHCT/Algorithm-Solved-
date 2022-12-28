//import java.io.*;
//import java.util.StringTokenizer;
//
//public class no1018 {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//
//        // 행렬을 받아옴
//        String[][] data = new String[N][M];
//        for (int i = 0; i < N; i++) {
//            String temp = br.readLine();
//            for (int j = 0; j < M; j++) {
//                data[i][j] = String.valueOf(temp.charAt(j));
//            }
//        }
//
//        int min = 64;
//        for (int i = 0; i < N-7; i++) {
//            for (int j = 0; j < M-7; j++) {
//                min = recur(min,0, data,i, j, j);
//            }
//        }
//
//        bw.write(""+min+"\n");
//        bw.close();
//    }
//
//
//    private static int recur(int min, int count, String[][] data, int low, int cul, int baseCul) {
//        // 중간 탈출
//        if (count >= min) return min;
//
//        // 최종탈출
//        if (low == 7 && cul == 7) {
//            min = count;
//            return min;
//        }
//
//        // 칠하기 영역 + count영역
//        if (low != 7 && cul != 7) {
//            if (data[low][cul].equals("B")) {
//                if (data[low + 1][cul].equals("B")) count++;
//                data[low + 1][cul] = "W";
//
//                if (data[low][cul + 1].equals("B")) count++;
//                data[low][cul + 1] = "W";
//            } else if (data[low][cul].equals("W")) {
//                if (data[low + 1][cul].equals("W")) count++;
//                data[low + 1][cul] = "B";
//
//                if (data[low][cul + 1].equals("W")) count++;
//                data[low][cul + 1] = "B";
//            }
//            return recur(min, count, data, low, cul + 1, baseCul);
//        } else if (low != 7 && cul == 7) {
//            if (data[low][cul].equals("B")) {
//                if (data[low + 1][cul].equals("B")) count++;
//                data[low + 1][cul] = "W";
//
//            } else if (data[low][cul].equals("W")) {
//                if (data[low + 1][cul].equals("W")) count++;
//                data[low + 1][cul] = "B";
//            }
//            return recur(min, count, data, low + 1, baseCul, baseCul);
//        } else if (low == 7 && cul != 7) {
//            if (data[low][cul].equals("B")) {
//                if (data[low][cul + 1].equals("B")) count++;
//                data[low][cul + 1] = "W";
//            } else if (data[low][cul].equals("W")) {
//                if (data[low][cul + 1].equals("W")) count++;
//                data[low][cul + 1] = "B";
//            }
//            return recur(min, count, data, low, cul+1, baseCul);
//        }
//
//        return min;
//    }
//}
//
