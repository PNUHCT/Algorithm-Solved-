import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int D = Integer.parseInt(st.nextToken());
        int ea = Integer.parseInt(st.nextToken());
        int change = Integer.parseInt(st.nextToken());
        int answer = D * ea - change;
        System.out.println(answer>=0 ? answer : 0);
    }
}

