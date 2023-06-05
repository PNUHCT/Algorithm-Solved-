import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no11444 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static List<BigInteger> list = new ArrayList<>();
    private static BigInteger mod = new BigInteger("1000000007");

    public static void main(String[] args) throws IOException {
        list.add(new BigInteger("0"));
        list.add(new BigInteger("0"));
        list.add(new BigInteger("1"));

        int N = Integer.parseInt(br.readLine());

        if(N==2) System.out.println(1);
        else {
            for(int i=3; i<=N ; i++) {
                BigInteger two = list.get(i-2);
                BigInteger one = list.get(i-1);
                list.add(i, two.add(one));
            }
            System.out.println(list.get(N).mod(mod));
        }
    }
}

