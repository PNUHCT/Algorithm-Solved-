import java.io.*;
import java.util.PriorityQueue;

public class no1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        PriorityQueue<Integer> que = new PriorityQueue<>(); // 우선순위 큐

        for(int i=0; i<T ; i++) {
            Integer num = Integer.parseInt(br.readLine()); // 입력된 숫자
            if(num.equals(0)) {                            // 입력이 0일 경우,
                if(que.isEmpty()) bw.write("0\n");     //  1. 큐가 비어있으면 0을 출력
                else bw.write(""+ que.poll() +"\n");   //  2. 큐에 숫자가 있으면, 제일 작은수가 맨 앞에 와있으므로 바로 poll()
            } else que.add(num);                           //  입력이 0이 아닌 경우, que에 넣음
        }
        bw.close(); // 출력
    }
}