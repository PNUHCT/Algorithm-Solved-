import java.io.*;
import java.util.StringTokenizer;

public class no10951 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 임의의 반복
        for (int i=0; i<100; i++) {
            try {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                bw.write("" + (A + B) + "\n");
            } catch (Exception e) {
                break;
            }
        }

        bw.close();
    }
}