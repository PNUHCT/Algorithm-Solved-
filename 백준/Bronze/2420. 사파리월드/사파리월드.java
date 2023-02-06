import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger i = new BigInteger(st.nextToken());
        BigInteger j = new BigInteger(st.nextToken());
        System.out.println(i.subtract(j).abs());
    }
}