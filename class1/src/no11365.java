import java.io.*;

public class no11365 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        while (true) {
            String code = br.readLine();
            if (code.equals("END")) break;
            for (int i = code.length() - 1; i >= 0; i--) bw.write(code.charAt(i));
            bw.write("\n");
        }
        bw.close();
    }
}