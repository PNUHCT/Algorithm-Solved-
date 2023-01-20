import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;
            String[] strArr = str.split("");
            String result = "yes";

            List<String> list = Arrays.stream(strArr).filter(a -> a.equals("(") || a.equals("[") || a.equals(")") || a.equals("]")).collect(Collectors.toList());
            Deque<String> dq = new ArrayDeque<>();

            for (String bal : list) {
                if (bal.equals("(") || bal.equals("[")) dq.addLast(bal);

                if (bal.equals(")")) {
                    if (dq.isEmpty()) {
                        result = "no";
                        break;
                    }
                    else if (dq.peekLast().equals("(")) {
                        dq.pollLast();
                    }
                    else {
                        result = "no";
                        break;
                    }
                }

                if (bal.equals("]")) {
                    if (dq.isEmpty()) {
                        result = "no";
                        break;
                    }
                    else if (dq.peekLast().equals("[")) {
                        dq.pollLast();
                    }
                    else {
                        result = "no";
                        break;
                    }
                }
            }
            if(!dq.isEmpty()) result= "no";
            sb.append(result + "\n");
        }

        System.out.println(sb);
    }
}

