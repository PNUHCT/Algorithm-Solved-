import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class no26711 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BigInteger A, B;

    public static void main(String[] args) throws IOException {
        A = new BigInteger(br.readLine());
        B = new BigInteger(br.readLine());
        System.out.println(A.add(B));
    }
}


