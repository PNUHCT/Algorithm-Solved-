import java.io.*;
import java.util.*;

public class no1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken());
            Deque<int[]> dq = new ArrayDeque<>();
            ArrayList<Integer> list = new ArrayList<>();
            int goal = 0;
            int count = 1;

            for (int j = 1; j <= num; j++) {
                int temp = Integer.parseInt(st2.nextToken());
                dq.add(new int[]{j, temp});
                list.add(temp);
                if (j == location+1) goal = j;
            }

            Collections.sort(list, Collections.reverseOrder());

            while(!list.isEmpty()) {
                if (dq.peek()[1] == list.get(0)) {
                    if (dq.peek()[0] == goal) {
                        bw.write(""+count+"\n");
                        break;
                    }
                    list.remove(0);
                    dq.poll();
                    count++;
                } else {
                    dq.add(dq.poll());
                }
            }
        }

        bw.close();
    }
}

