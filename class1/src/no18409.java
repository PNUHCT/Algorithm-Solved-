import java.io.*;
import java.util.ArrayList;

public class no18409 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;
    private static ArrayList<String> gather = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        gather.add("a");
        gather.add("i");
        gather.add("u");
        gather.add("e");
        gather.add("o");
        int count = 0;

        String[] str = br.readLine().split("");

        for(String c : str) if(gather.contains(c)) count++;

        System.out.println(count);
    }
}