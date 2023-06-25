import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class no1918 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String str;
    private static Deque<Character> dq = new ArrayDeque<>();;

    public static void main(String[] args) throws IOException {
        str = br.readLine();

        // 각 테스트 케이스마다 나올 문자열 형태의 중위 표기식의 문자를 순회
        for(int i=0; i<str.length() ; i++) Adj(str.charAt(i)); // 판단을 Adj에 위임

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
            // 사칙연산의 경우, 우선순위를 두어 -> 연산자 대기열에 있는 연산자들 중 현재 연산자보다 높은 우선순위를 가진 연산자를 최종출력에 넣고 제외함
            // 이후 현재 연산자는 아직 뒤에 나올 연산자와 비교하지 못했으므로 대기열에 넣어줌
            case '+':
            case '-':
            case '*':
            case '/':
                while (!dq.isEmpty() && priority(dq.peekLast()) >= priority(now)) bw.append(dq.pollLast());
                dq.add(now);
                break; // break없으면 순서가 뒤죽박죽됨
            // 여는 괄호는 닫는 괄호가 나올때까지 확인이 필요하므로 대기열에 둠
            case '(':
                dq.add(now);
                break; // break없으면 순서가 뒤죽박죽됨
            // 닫는 괄호는 앞서 나온 가까운 여는 괄호를 찾아야하며, 그 전까지 있는 모든 연산자를 최종출력에 담아줌
            case ')':
                while (!dq.isEmpty() && dq.peekLast() != '(') bw.append(dq.pollLast());
                dq.pollLast();
                break;
            // 기본적으로 피연산자는 바로 최종출력
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
        return -1; // 피연산자
    }
}