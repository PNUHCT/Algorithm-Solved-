import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int round = 7;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while(round-->0) {
            int now = Integer.parseInt(br.readLine());

            if(now%2==1) {
                sum += now;
                min = Math.min(min, now);
            }
        }
        if(sum==0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}