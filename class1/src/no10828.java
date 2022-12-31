import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                stack.push(st.nextToken());
            } else if (cmd.equals("top")) {
                if(stack.isEmpty()) bw.write("-1"+"\n");
                else bw.write(stack.peek() + "\n");
            } else if (cmd.equals("size")) {
                bw.write(stack.size() + "\n");
            } else if (cmd.equals("empty")) {
                if (stack.size() == 0) bw.write("1" + "\n");
                else bw.write("0" + "\n");
            } else if (cmd.equals("pop")) {
                if (stack.isEmpty()) bw.write("-1" + "\n");
                else bw.write(stack.pop() + "\n");
            }
        }
        bw.close();
    }
}

/* v프리베이트 메서드를 따로빼면 깔끔은 하나, 미묘하게 속도가 느려짐 */
//    private static void command(String cmd, Stack<String> stack, StringTokenizer st, BufferedWriter bw) throws IOException {
//        if (cmd.equals("push")) {
//            stack.push(st.nextToken());
//        } else if (cmd.equals("top")) {
//            bw.write(stack.peek()+"\n");
//        } else if (cmd.equals("size")) {
//            bw.write(stack.size()+"\n");
//        } else if (cmd.equals("empty")) {
//            if(stack.size()==0) bw.write("1"+"\n");
//            else bw.write("0"+"\n");
//        } else if (cmd.equals("pop")) {
//            if(stack.isEmpty()) bw.write("-1"+"\n");
//            else bw.write(stack.pop()+"\n");
//        }
//    }
//}

