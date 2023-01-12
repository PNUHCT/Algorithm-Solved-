import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            String line = br.readLine();
            Deque<String> dq = new ArrayDeque<>();
            String result="";
            for(int j=0 ; j<line.length() ; j++) {
                String str = String.valueOf(line.charAt(j));
                if(str.equals("(")) dq.addLast(str);
                else if (str.equals(")") && dq.isEmpty()) {
                    result = "NO";
                    break;
                }
                else if (str.equals(")") && dq.peekLast().equals("(")) dq.pollLast();
                else if (str.equals(")")) dq.addLast(str);
            }

            if(!dq.isEmpty()) bw.write("NO\n");
            else if(result.equals("NO")) bw.write(result+"\n");
            else bw.write("YES\n");
        }
        bw.close();
    }
}