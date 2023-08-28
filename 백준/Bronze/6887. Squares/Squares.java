import java.io.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        int a = (int) Math.sqrt(T);
        System.out.println(String.format("The largest square has side length %d.", a));
    }
}