import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no11660 {
    private static int N, M, x1, x2, y1, y2;
    private static int[][] matrix;
//    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 이중배열로 구하는 방식
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st2.nextToken());
            }
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            x1 = Integer.parseInt(st2.nextToken());
            y1 = Integer.parseInt(st2.nextToken());
            x2 = Integer.parseInt(st2.nextToken());
            y2 = Integer.parseInt(st2.nextToken());

            bw.write(""+calculate()+"\n");
        }

        bw.close();
    }
    private static int calculate () {
        int sum = 0;
        for (int y = y1; y <= y2; y++) {
            for (int x = x1; x <= x2; x++) {
                if(x>=x1) sum += matrix[y-1][x-1];
            }
        }
        return sum;
    }
}

        // DP

        /* DP 점화식
         (1N + x1) + (1N + (x1 + 1)) + (1N + ((x1 + 2)) + ... + (1N + ((x2 - x1 + 1))
         ...
         ((y2 - y1 + 1)N + x1) + ((y2 - y1 + 1)N + (x1 + 1)) + ((y2 - y1 + 1)N + ((x1 + 2)) + ... + ((y2 - y1 + 1)N + ((x2 - x1 + 1))

         =
         for(int i = 1 ; i<= y2 - y1 +1 ; i++) {
            int sum = factorial(x2 - x1) + ((x1 + N) * (x2 - x1 + 1));
         }
        */

//        arr = new int [N*N+1]; // 매트릭스fmf 1차원 배열로 나열
//        int num = 0;
//        for (int y = 0; y < N ; y++) {
//            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
//            for (int x = 0 ; x < N ; x++) {
//                num += 1;
//                arr[num] = Integer.parseInt(st2.nextToken());
//            }
//        }
//
//        /**
//         * 조건문으로 반복
//         */
//        for (int i=0 ; i<M ; i++) {
//            StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
//            x1 = Integer.parseInt(st3.nextToken());
//            y1 = Integer.parseInt(st3.nextToken());
//            x2 = Integer.parseInt(st3.nextToken());
//            y2 = Integer.parseInt(st3.nextToken());
//
//            bw.write(""+calculate()+"\n");
//        }
//
//        bw.close();
//    }
//
//
//    private static int calculate () {
//        int sum = 0;
//        int start = (N*y1) - (N-x1);
//        int end = (N*y2) - (N-x2);
//
//        while(start<=end) {
//            if((start>=(x1+(N*(y1-1))) && start<=x2+(N*(y2-1)))) { // 중간 부분을 생략하는 방법?
//                sum += arr[start];
//                start++;
//            }
//            else if(start<=x1) continue;
//            else start += (N-x1);
//        }
//        // 1 2 3 4 2 3 4 5 3  4  5  6  4  5  6  7
//        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//        return sum;
//    }
//
//    private static int factorial (int a) {
//        if(a <= 1) return a;
//        else return factorial(a-1) * a;
//    }
//}

