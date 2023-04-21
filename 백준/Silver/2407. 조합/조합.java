import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // nCm = n! / (m! * (n-m)!)
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        BigInteger result = factorial(n).divide((factorial(m).multiply(factorial(n.subtract(m)))));
        System.out.println(result);
    }

    private static BigInteger factorial(BigInteger a) {
        if(a.compareTo(BigInteger.valueOf(1))<=0) return a;
        else return factorial(a.subtract(BigInteger.valueOf(1))).multiply(a);
    }
}