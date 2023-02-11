import java.io.*;
import java.math.BigInteger;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static PriorityQueue<Integer> queue;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        
        queue = new PriorityQueue<>((a,b) -> {
            if(Math.abs(a) == Math.abs(b)) return a > b ? 1 : -1;
            return Math.abs(a) - Math.abs(b);
        }); // 핵심로직 : 우선순위 큐. 절대값이 같으면 더 작은놈. 그 외엔 절대값이 더 작은 놈을 우선 뺌
        
        for(int i=0; i<T ; i++) {
            Integer num = Integer.parseInt(br.readLine());
            calculate(num);
        }
        bw.close();
    }

    private static void calculate (Integer num) throws IOException {
        if(num.equals(0)) {
            if(queue.isEmpty()) bw.write("0\n");
            else bw.write(""+queue.poll()+"\n");
        }
        else queue.add(num);
    }
}