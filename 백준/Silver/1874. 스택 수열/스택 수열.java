import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        boolean no = false;
        int count = 0;
        for(int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());

            if(stack.empty()) {
                count++;
                stack.push(count);
                sb.append("+").append("\n");
            }

            while(stack.peek()!=num && count<=T) {
                count++;
                stack.push(count);
                sb.append("+").append("\n");
            }

            if(stack.peek()!=num && count>T) {
                no = true;
                break;
            }

            stack.pop();
            sb.append("-").append("\n");
        }

        if(no) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}