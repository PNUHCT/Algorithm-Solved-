import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no5596 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");

        int sum1 = 0;
        int sum2 = 0;
        for(int i=0 ; i<4 ; i++) {
            sum1 += Integer.parseInt(arr1[i]);
            sum2 += Integer.parseInt(arr2[i]);
        }

        int max = sum1>=sum2 ? sum1 : sum2;
        System.out.println(max);
    }
}