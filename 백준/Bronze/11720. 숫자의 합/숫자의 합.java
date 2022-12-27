import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int sum = 0;
        for (int i = 0; i < T; i++) {
            sum += Integer.parseInt(arr[i]);
        }
        bw.write("" + sum + "\n");
        bw.close();
    }
}
