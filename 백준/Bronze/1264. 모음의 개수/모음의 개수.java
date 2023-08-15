import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));

    public static void main(String[] args) throws IOException {
        while (true) {
            String str = br.readLine().toLowerCase();
            if (str.equals("#")) break;

            String[] line = str.split("");
            int cnt = 0;
            for (String cha : line) if (list.contains(cha)) cnt++;

            System.out.println(cnt);
        }
    }
}