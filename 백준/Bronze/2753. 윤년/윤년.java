import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        if (T%400==0) System.out.println(1);
        else if(T%4==0 && T%100!=0) System.out.println(1);
        else System.out.println(0);

    }
}