import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long N = Long.valueOf(br.readLine());
        String fact = String.valueOf(factorial(N));

        // 0! = 1 * 0! = 1이다.
        int result = 0;
        for (int i = fact.length() - 1; i >= 0; i--) {
            if (fact.charAt(i) != '0') break;
            result++;
        }
        System.out.println(result);
    }

    public static BigInteger factorial(Long n) {
        BigInteger p = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            p = p.multiply(BigInteger.valueOf(i));
        }
        return p;
    }
}