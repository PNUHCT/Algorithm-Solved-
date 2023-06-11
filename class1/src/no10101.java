import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no10101 {

    private static int  A,B,C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = Integer.parseInt(br.readLine());
        B = Integer.parseInt(br.readLine());
        C = Integer.parseInt(br.readLine());

        if (A + B + C != 180) System.out.println("Error");
        else {
            if (A == 60 && B == 60 && C == 60) System.out.println("Equilateral");
            else if (A != B && B != C && C != A) System.out.println("Scalene");
            else System.out.println("Isosceles");
        }
    }
}

