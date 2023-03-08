import java.io.*;

public class cuttingpaper {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        /**
         * M-1번 자르고,
         * M * (N-1)번 자르면 됨
         */
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
    }

    public static int Solution(int M, int N) {
        int answer = (M-1) + (M * (N-1));
        return answer;
    }
}
