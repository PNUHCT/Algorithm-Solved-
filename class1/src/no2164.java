import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=1; i<=T ; i++) dq.addLast(i);

        while(dq.size()!=1) {
            dq.pollFirst();
            dq.addLast(dq.pollFirst());
        }
        System.out.println(dq.pollFirst());
    }
}

