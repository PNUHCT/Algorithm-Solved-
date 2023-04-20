import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    private static long pow(long A, long exp) {
        if(exp == 1) return A % C; // 지수가 1일 경우

        long temp = pow(A, exp/2);

        if(exp % 2 == 1) return ((temp * temp % C) * A) % C; // 지수가 홀수일 경우

        return (temp * temp) % C; // 지수가 짝수일 경우
    }
}