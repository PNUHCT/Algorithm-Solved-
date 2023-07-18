import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no10830 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, T;
    private static Stack<Integer> stack = new Stack<>();
    private static int[][] initial;

    /**
     * T를 2로 나눈 나머지가 1인 경우를 1depth
     * 몫을 다시 나누기 시작해서 나머지가 1이 나오는 경우를 1depth
     * 몫이 1이될 떄까지 나눔. 1이 되면 거기서부터 순차적으로 행렬 제곱
     * 1인 depth까지 다시 올라오면서, 1depth당 최초 행렬 곱해줌
     *
     * 1. stack에서 0일경우 제곱, 1일경우 초기행렬곱
     * 2. 스택이 빌 때까지 반복
     */
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        while(T!=1) {
            if(T%2 == 1) stack.push(1);
            else stack.push(0);
        }

        initial = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++) initial[i][j] = Integer.parseInt(st.nextToken());
        }





        bw.close();
    }

    private static int[][] recur (int[][] matrix) {
        int[][] result = new int[N][N];



        return result;
    }
}

