import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while(true) {
            st = new StringTokenizer(br.readLine(), " ");
            int boy = Integer.parseInt(st.nextToken());
            int girl = Integer.parseInt(st.nextToken());
            if(boy==0 && girl==0) break;
            bw.write(""+(boy + girl)+"\n");
        }
        
        bw.close();
    }
}