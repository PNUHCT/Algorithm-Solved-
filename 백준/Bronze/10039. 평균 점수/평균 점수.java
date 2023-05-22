import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        for(int i=0; i<5 ; i++) {
            int now = Integer.parseInt(br.readLine());
            if(now<40) now = 40;
            sum += now;
        }

        System.out.println(sum/5);
    }
}