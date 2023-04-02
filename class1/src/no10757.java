import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no10757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger head = new BigInteger(st.nextToken());
        BigInteger tail = new BigInteger(st.nextToken());

        System.out.println(head.add(tail));
    }
}

