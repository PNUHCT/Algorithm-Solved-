import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        bw.write("" + (A + B) + "\n");
        bw.write("" + (A - B) + "\n");
        bw.write("" + (A * B) + "\n");
        bw.write("" + (A / B) + "\n");
        bw.write("" + (A % B) + "\n");


        bw.close();
    }
}