import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no14928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bigint = new BigInteger(br.readLine());
        BigInteger devide = new BigInteger("20000303");
        System.out.println(bigint.mod(devide));
    }
}