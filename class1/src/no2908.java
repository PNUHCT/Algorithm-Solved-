import java.io.*;
import java.util.*;

public class no2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] a = st.nextToken().split("");
        String[] b = st.nextToken().split("");
        String first = "";
        String second = "";

        for (int i = 2 ; i>=0 ; i--) {
            first += a[i];
            second += b[i];
        }
        int int1 = Integer.parseInt(first);
        int int2 = Integer.parseInt(second);
        int result = int2;
        if(int1>int2) result = int1;

        System.out.println(result);
    }
}

