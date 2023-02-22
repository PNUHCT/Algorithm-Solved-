import java.io.*;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int goal;
    static int[] arr = {1,2,3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            goal = Integer.parseInt(br.readLine());
            if(goal==1) bw.write("1\n");
            else if(goal==2) bw.write("2\n");
            else if(goal==3) bw.write("4\n");
            else bw.write(""+BFS()+"\n");
        }

        bw.close();
    }

    public static int BFS() {
        Deque<Integer> dq = new ArrayDeque<>();
        int count = 0;
        dq.add(1);
        dq.add(2);
        dq.add(3);

        while(!dq.isEmpty()) {
            int now = dq.poll();

            for(int i=0; i<3 ; i++) {
                int isPossible = now + arr[i];
                if(isPossible<goal) dq.add(isPossible);
                else if (isPossible==goal) count++;
            }
        }
        return count;
    }
}