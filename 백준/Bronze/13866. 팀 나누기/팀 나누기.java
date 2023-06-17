import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[4];
        for(int i=0 ; i<4 ; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        System.out.println(Math.abs((arr[0] + arr[3]) - (arr[1]+arr[2])));
    }
}