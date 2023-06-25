import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class no1918 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String str;
    private static Deque<Character> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        for(int i=0; i<str.length() ; i++) {
            char now = str.charAt(i);
            Adj(now);
        }

        while(!dq.isEmpty()) bw.append(dq.pollLast()); // 대기열에 배치한 연산자를 입력해주는 구간

        bw.close();
    }

    /**
     * 입력된 값에 따라 연산자/피연산자 구분 후
     * 피연산자일 경우, 출력할 Buffer에 담아주고
     * 연산자일 경우, 순서에 맞춰 대기열(dq)에 담아주는 판별 메소드
     */
    private static void Adj (Character now) throws IOException {
        switch (now) {
            case '+':
            case '-':
            case '*':
            case '/':
                while (!dq.isEmpty() && priority(dq.peekLast()) >= priority(now)) bw.append(dq.pollLast());
                dq.add(now);
                break;
            case '(':
                dq.add(now);
            case ')':
                while (!dq.isEmpty() && dq.peekLast() != '(') bw.append(dq.pollLast());
                dq.pollLast();
                break;
            default: bw.append(now);
        }
    }

    /**
     * 연산자(operator)별 우선순위를 지정해주는 메소드
     */
    private static int priority(Character operator) {
        if(operator=='(' || operator==')') return 0;
        else if(operator == '+' || operator=='-') return 1;
        else if(operator == '*' || operator=='/') return 2;
        return -1;
    }
}

