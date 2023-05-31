import java.util.*;
import java.io.*;

public class no2845 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int base = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        int num = 5;
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        while(num-->0) bw.write("" + (Integer.parseInt(st2.nextToken()) - base) + " ");
        
        bw.close();
    }
}
