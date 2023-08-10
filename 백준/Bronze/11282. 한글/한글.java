import java.io.*;
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        /**
         * 초성 : N을 21 * 28로 나눈 몫의 순서
         * 중성 : N을 21 * 28로 나눈 나머지를 다시 28로 나눈 몫의 순서
         * 종성 : N을 21 * 28로 나눈 나머지를 다시 28로 나눈 나머지의 순서
         */

        int cho = N / (21*28);
        int joong = (N % (21*28)) / 28;
        int jong =  (N % (21*28)) % 28;
        char result = (char) (((cho * 21 + joong) * 28 + jong) -1 + 0xAC00);
        System.out.println(result);

        bw.close();
    }
}