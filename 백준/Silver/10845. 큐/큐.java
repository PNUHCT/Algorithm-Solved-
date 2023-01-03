import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            command(que, st, bw);
        }

        bw.close();
    }

    private static void command(Deque<Integer> que, StringTokenizer st, BufferedWriter bw) throws IOException {
        String cmd = st.nextToken();
        if (cmd.equals("push")) {
            int X = Integer.parseInt(st.nextToken());
            que.add(X);
        } else if (cmd.equals("pop")) {
            if (que.isEmpty()) bw.write("-1\n");
            else bw.write(""+que.poll()+"\n");
        } else if (cmd.equals("size")) {
            bw.write(""+que.size()+"\n");
        } else if (cmd.equals("empty")) {
            if (que.isEmpty()) bw.write("1\n");
            else bw.write("0\n");
        } else if (cmd.equals("front")) {
            if (que.isEmpty()) bw.write("-1\n");
            else bw.write(""+que.peekFirst()+"\n");
        } else if (cmd.equals("back")) {
            if (que.isEmpty()) bw.write("-1\n");
            else bw.write(""+que.peekLast()+"\n");
        }
    }
}