import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 분할 정복 : B를 나눠 불필요한 탐색을 최소화
 */

public class no10830 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private  static long B;
    private static int[][] origin;
    private static int mod = 1000;
    private static Stack<Integer> stack = new Stack<>();
    private static int[][] multi_matrix;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 입력 구간
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) origin[i][j] = Integer.parseInt(st.nextToken()) % mod;
        }

        // 레퍼런스 코드 방식 호출 및 출력 입력
        int[][] result = pow(origin, B);

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N; j++) {
                bw.append("" + result[i][j]).append(" ");
            }
            bw.write("\n");
        }


        // 내 코드 방식 호출
        while (B != 1) {
            if (B % 2 == 1) stack.push(1);
            else stack.push(0);
            B /= 2;
        }

        multi_matrix = origin;

        while(!stack.isEmpty()) {
            int now = stack.pop();
            pow2(now);
        }


        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N; j++) {
                bw.append("" + multi_matrix[i][j]).append(" ");
            }
            bw.write("\n");
        }

        bw.close();
    }

    /**
     *
     * @param matrix : 대상이 되는 행렬
     * @param exp : 현재의 지수
     * @return 반환될 행렬
     */
    private static int[][] pow (int[][] matrix, long exp) {

        // 지수가 1일 땐 A를 반환
        if(exp == 1L) return matrix;

        // 지수를 절반으로 분할하여 재귀
        int[][] temp = pow(matrix, exp/2);

        // 하위 재귀에서 얻은 행렬을 제곱
        temp = multifly(temp, temp);

        // 지수가 홀수 일 때,
        if(exp % 2 == 1L) temp = multifly(temp, origin);

        return temp;
    }

    /**
     * 행렬 * 행렬 메소드
     * 1번 경우 : 재귀로 얻은 동일 행렬 (mat1 == mat2)
     * 2번 경우 : 재귀로 얻은 행렬 * 초기행렬
     */
    private static int[][] multifly(int[][] mat1, int[][] mat2) {
        int [][] result = new int [N][N];

        for(int i=0 ; i<N ; i++) {
            for(int j=0 ; j<N ; j++) {
                for(int k=0 ; k<N ; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                    result[i][j] %= mod; // 연산이 끝날때마다 모듈러 연산
                }
            }
        }

        return result;
    }


    private static void pow2 (int now) {
        if(now==0) {
            multi_matrix = multifly(multi_matrix, multi_matrix);
        } else {
            multi_matrix = multifly(origin, multifly(multi_matrix, multi_matrix));
        }
    }
}

