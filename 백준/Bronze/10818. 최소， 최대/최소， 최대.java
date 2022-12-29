import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long max = -1000000;
        long min = 1000000;
        for(int i=0; i<T ; i++) {
            long temp = Long.parseLong(st.nextToken());
            if(temp>=max) max = temp;
            if(temp<=min) min = temp;
        }
        System.out.println(String.format("%d %d", min,max));
    }
}
