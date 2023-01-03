import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            command(que, st);
        }
    }

    private static void command(Deque<Integer> que, StringTokenizer st) {
        String cmd = st.nextToken();
        if(cmd.equals("push")) {
            int X = Integer.parseInt(st.nextToken());
            que.add(X);
        } else if (cmd.equals("pop")) {
            if (que.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(que.poll());
            }
        } else if (cmd.equals("size")) {
            System.out.println(que.size());
        } else if (cmd.equals("empty")) {
            if (que.isEmpty()) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else if (cmd.equals("front")) {
            if(que.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(que.peekFirst());
            }
        } else if (cmd.equals("back")) {
            if(que.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(que.peekLast());
            }
        }
    }
}

