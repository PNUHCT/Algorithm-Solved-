import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0; i<K ; i++) {
            String num = br.readLine();
            if(num.equals("0")) dq.pollLast();
            else dq.add(Integer.parseInt(num));
        }

        int sum = 0;
        while(!dq.isEmpty()) sum += dq.pollFirst();
        System.out.println(sum);
    }
}