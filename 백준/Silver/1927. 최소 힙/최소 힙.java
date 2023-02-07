import java.io.*;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int i=0; i<T ; i++) {
            Integer num = Integer.parseInt(br.readLine());
            if(num.equals(0)) {
                if(que.isEmpty()) bw.write("0\n");
                else bw.write(""+ que.poll() +"\n");
            } else que.add(num);
        }
        bw.close();
    }
}