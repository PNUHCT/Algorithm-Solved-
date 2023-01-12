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
            char arr[] = br.readLine().toCharArray();
            Deque<Character> dq = new ArrayDeque<>();
            boolean result= false;
            for(int j=0 ; j<arr.length ; j++) {
                if(arr[j]=='(') dq.addLast('(');
                else if (arr[j]==')' && dq.isEmpty()) {
                    result = true;
                    break;
                }
                else if (arr[j]==')' && dq.peekLast()=='(') dq.pollLast();
                else if (arr[j]==')') dq.addLast(')');
            }
            if(!dq.isEmpty()) bw.write("NO\n");
            else if(result) bw.write("NO\n");
            else bw.write("YES\n");
        }
        bw.close();
    }
}

