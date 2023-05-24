import java.io.*;
import java.util.StringTokenizer;

public class no11660 {
    private static int N, M, x1, x2, y1, y2;
    private static int[] arr;
    private static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력 구간
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // DP
       arr = new int [N*N+1]; // 매트릭스fmf 1차원 배열로 나열
       int num = 0;
       for (int y = 0; y < N ; y++) {
           StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
           for (int x = 0 ; x < N ; x++) {
               num += 1;
               arr[num] = Integer.parseInt(st2.nextToken());
           }
       }

       /**
        * 조건문으로 반복
        */
       for (int i=0 ; i<M ; i++) {
           StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
           x1 = Integer.parseInt(st3.nextToken());
           y1 = Integer.parseInt(st3.nextToken());
           x2 = Integer.parseInt(st3.nextToken());
           y2 = Integer.parseInt(st3.nextToken());
           calculate();    
           bw.write(""+DP[(y2-1)*N+x2]+"\n");
       }

       bw.close();
   }


    // 1  2  3  4  2  3  4  5  3  4  5  6  4  5  6  7
    // 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16
   private static void calculate () {
       DP = new int[N*N+1];
       int num = (N*(y1-1))+x1;
       int finish = (N*(y2-1))+x2;
       int last = 0;

       while(num<=finish) {
            if(num%N>x2) {
                num += ((N-x2)+x1);
            } else if (num%N == 0 && x2!=N) { // x2와 N이 같은 경우의 엣지케이스
                num += x1;
            }else {
                DP[num] = DP[last] + arr[num];
                last = num;
                num++;
            }
       }
   }
}


        /* DP 점화식
         (1N + x1) + (1N + (x1 + 1)) + (1N + ((x1 + 2)) + ... + (1N + ((x2 - x1 + 1))
         ...
         ((y2 - y1 + 1)N + x1) + ((y2 - y1 + 1)N + (x1 + 1)) + ((y2 - y1 + 1)N + ((x1 + 2)) + ... + ((y2 - y1 + 1)N + ((x2 - x1 + 1))

         =
         for(int i = 1 ; i<= y2 - y1 +1 ; i++) {
            int sum = factorial(x2 - x1) + ((x1 + N) * (x2 - x1 + 1));
         }
        */