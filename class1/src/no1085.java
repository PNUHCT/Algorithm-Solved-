import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class no1085 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int move1 = (W/2>=X) ? X : W - X;
        int move2 = (H/2>=Y) ? Y : H - Y;

        int result = move1<=move2 ? move1 : move2;
        System.out.println(result);

    }
}

