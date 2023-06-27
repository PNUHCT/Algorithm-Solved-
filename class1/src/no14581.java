import java.io.*;
public class no14581 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        sb.append(":fan::fan::fan:\n");
        sb.append(":fan::" + br.readLine() + "::fan:\n");
        sb.append(":fan::fan::fan:");

        System.out.println(sb.toString());
    }
}

