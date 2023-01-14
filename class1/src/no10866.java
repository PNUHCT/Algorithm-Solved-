import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            command(dq, st, bw);
        }
        
        bw.close();  
    }
    
    private static void command(Deque<Integer> dq, StringTokenizer st, BufferedWriter bw) throws IOException {
        String cmd = st.nextToken();
        if(cmd.equals("push_front")) dq.addFirst(Integer.valueOf(st.nextToken()));

        else if (cmd.equals("push_back")) dq.addLast(Integer.valueOf(st.nextToken()));

        else if (cmd.equals("pop_front")) {
            if(dq.isEmpty()) bw.write("-1\n");
            else bw.write(""+dq.pollFirst()+"\n");
        }

        else if (cmd.equals("pop_back")) {
            if(dq.isEmpty()) bw.write("-1\n");
            else bw.write(""+dq.pollLast()+"\n");
        }

        else if (cmd.equals("size")) bw.write(""+dq.size()+"\n");

        else if (cmd.equals("empty")) {
            if(dq.isEmpty()) bw.write("1\n");
            else bw.write("0\n");
        }

        else if (cmd.equals("front")) {
            if(dq.isEmpty()) bw.write("-1\n");
            else bw.write(""+dq.peekFirst()+"\n");
        }

        else if (cmd.equals("back")) {
            if(dq.isEmpty()) bw.write("-1\n");
            else bw.write(""+dq.peekLast()+"\n");
        }
    }
}

