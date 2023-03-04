import java.io.*;
import java.util.StringTokenizer;

public class no3733 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int N = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                if (S / (N + 1) != 0) {
                    bw.write("" + (S / (N + 1)) + "\n");
                } else bw.write("0\n");
            } catch (Exception e) {
                break;
            }
        }
        bw.close();
    }
}

