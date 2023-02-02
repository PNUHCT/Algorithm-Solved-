import java.io.*;
import java.util.*;

public class no5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String p = br.readLine();
            int N = Integer.parseInt(br.readLine());

            String arr = br.readLine().replace("[", "").replace("]", "").replace(",", " ");
            StringTokenizer st = new StringTokenizer(arr, " ");
            Deque<String> dq = new ArrayDeque<>();
            while (N-- > 0) dq.add(st.nextToken());

            AC(dq, p, bw);
        }

        bw.close();
    }

    private static void AC(Deque<String> dq, String commands, BufferedWriter bw) throws IOException {
        boolean reverse = false;
        for (char command : commands.toCharArray()) {
            if (command == 'R') reverse = !reverse;
            else {
                if (dq.size() == 0) bw.write("error\n");
                if (reverse) dq.pollLast();
                else dq.pollFirst();
            }
        }
        List<String> list = new ArrayList<>();
        while (!dq.isEmpty()) list.add(reverse ? dq.pollLast() : dq.pollFirst());
        if(!list.isEmpty()) bw.write(list+"\n");
    }
}




