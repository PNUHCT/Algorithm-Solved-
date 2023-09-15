import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BigInteger ORG, K, NUM;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ORG = new BigInteger(st.nextToken());
        K = new BigInteger(st.nextToken());
        NUM = new BigInteger("1");

        while (true) {
            if( NUM.compareTo(K) == 1 || NUM.compareTo(K) == 0 ) {
                System.out.println("GOOD");
                break;
            }

            NUM = NUM.add(BigInteger.ONE);

            if(ORG.remainder(NUM).compareTo(BigInteger.ZERO) == 0 && NUM.compareTo(K) == -1) {
                System.out.println("BAD " + NUM);
                break;
            }
        }
    }
}