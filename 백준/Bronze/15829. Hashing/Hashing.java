import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        double r = 31;
        double i = 0;
        long result = 0;
        char[] arr = br.readLine().toCharArray();

        for(Character c:arr) {
            result += Math.pow(r, i) * (c - 96);
            i++;
        }

        System.out.println(result);
    }
}