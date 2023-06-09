import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer[] science = new Integer[4];
        for(int i=0; i<4 ; i++) science[i] = Integer.parseInt(br.readLine());
        Arrays.sort(science,Collections.reverseOrder());

        Integer[] humanities = new Integer[2];
        for(int i=0; i<2; i++) humanities[i] = Integer.parseInt(br.readLine());

        int sum = science[0] + science[1] + science[2] + Math.max(humanities[0],humanities[1]);
        System.out.println(sum);
    }
}