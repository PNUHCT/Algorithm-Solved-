import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 0;
        int rank = 0;
        for(int i=1; i<=9 ; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (max<=temp) {
                max = temp;
                rank = i;
            }
        }
        bw.write(""+max+"\n");
        bw.write(""+rank+"\n");

        bw.close();
    }
}
