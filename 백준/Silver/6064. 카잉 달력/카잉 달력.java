import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
     * M, N이 주어진다.
     * 각각 X<=M 이고, Y<=N 이다.
     * 매 년 X+1, Y+1이된다.
     * M,N과 X,Y가 주어질 때, X,Y는 몇번째 차례인지 구해라.
     * 단, X, Y가 유효하지 않다면, -1을 출력해라
     */

    private static int M;
    private static int N;
    private static int X;
    private static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            bw.write("" + calculate() + "\n");
        }
        bw.close();
    }

    private static int calculate() {
        int result = -1; // 유효하지 않은 경우, -1이 출력
        int LCM = M * N / GCD(M, N); // 최소공배수 = 두 수의 곱 / 최대공약수
        int rotate = 0; // 몇바퀴 돌았는지 확인
        
        while (rotate * M < LCM) {
            if ((rotate * M + X - Y) % N == 0) {
                result = rotate * M + X; // 카잉달력의 앞자리 수가 몇번 반복됬는지 + X만큼의 추가이동 = 총 반복 수
                break;
            }
            rotate++;
        }
        return result;
    }

    /**
     * 최대공약수를 구하는 공식 (유클리도 호제법)
     *
     * @return 나머지가 0일때까지 나눠주는 방식으로, 나머지가 0이되는 수 중 가정 먼저 나온 수가 최대 공약수이다.
     */
    private static int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}