import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int apple1, apple2, orange1, orange2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        apple1 = Integer.parseInt(st1.nextToken());
        orange1 = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        apple2 = Integer.parseInt(st2.nextToken());
        orange2 = Integer.parseInt(st2.nextToken());

        System.out.println(Math.min(apple1 + orange2, apple2 + orange1));
    }
}