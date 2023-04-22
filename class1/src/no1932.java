import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1932 {

    private static int T;
    private static int[][] map;
    private static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        map = new int[T][T];
        memory = new int[T + 1];
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < i; j++) {
                int token = Integer.parseInt(st.nextToken());
                map[i - 1][j] = token;
            }
        }
        memory[0] = map[0][0];
        calculate(0, 0);

        System.out.println(memory[T]);
    }

    private static void calculate(int now, int level) {
        level++;
        if (level >= T) {
            if (memory[T] <= memory[T - 1]) memory[T] = memory[T - 1];
        } else {
            for (int i = 0; i < 2; i++) {
                int nextIdx = now + i;
                int nextNum = map[level][nextIdx];
                memory[level] = memory[level - 1] + nextNum;
                calculate(nextIdx, level);
            }
        }
    }
}