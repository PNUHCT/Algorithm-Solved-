import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if(str.equals(".")) break;

            Deque<String> dq = new ArrayDeque<>();


            String result = "yes";
            for(int i=0 ; i<str.length() ; i++) {
                if(str.charAt(i)=='(' || str.charAt(i)=='[') dq.addLast(String.valueOf(str.charAt(i)));
                else if(str.charAt(i)==')') {
                    if (dq.isEmpty()) {
                        result = "no";
                        break;
                    }
                    else if(dq.peekLast().equals("(")) dq.pollLast();
                    else if (!dq.peekLast().equals("(")) {
                            result = "no";
                            break;
                    }
                }
                else if(str.charAt(i)==']') {
                    if (dq.isEmpty()) {
                        result = "no";
                        break;
                    }
                    else if(dq.peekLast().equals("[")) dq.pollLast();
                    else if (!dq.peekLast().equals("[")) {
                        result = "no";
                        break;
                    }
                }
            }
            if(!dq.isEmpty()) result= "no";
            sb.append(result+"\n");
        }

        System.out.println(sb);
    }
}

