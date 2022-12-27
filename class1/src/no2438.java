import java.io.*;
import java.util.StringTokenizer;

public class no2438 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            String star = "";
            for(int j=0; j<i ; j++){
                star += "*";
            }
            bw.write(star+"\n");
        }

        bw.close();
    }

}

