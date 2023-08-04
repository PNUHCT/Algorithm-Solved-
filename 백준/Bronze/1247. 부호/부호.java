import java.io.*;
import java.math.BigInteger;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;
    private static BigInteger Sum, Base;

    public static void main(String[] args) throws IOException {
        Base = new BigInteger("0");
        for(int t = 0 ; t <3 ; t++) {
            T = Integer.parseInt(br.readLine());
            Sum = new BigInteger("0");

            for (int i = 0; i < T; i++) {
                BigInteger bi = new BigInteger(br.readLine());
                Sum = Sum.add(bi);
            }

            if(Sum.compareTo(Base) == -1) System.out.println("-");
            else if (Sum.compareTo(Base) == 0) System.out.println("0");
            else System.out.println("+");
        }
    }
}