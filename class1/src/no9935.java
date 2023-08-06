import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class no9935 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Deque<Character> dq, clipBoard;
    private static String str, boom;

    public static void main(String[] args) throws IOException {
        // 탐색할 문자열
        str = br.readLine();
        // 필터링 할 단어
        boom = br.readLine();
        // 남는 단어 넣을 기본 배열
        dq = new ArrayDeque<>();
        /* 비교군 비울 배열
        1. 필터링 할 단어의 역순으로 순차적으로 비교해서 일치하면 담음
        2. 만약 모두 일치하면 비우기
        3. 만약 중간에 일치하지 않으면 다시 원위치 시킴
        */
        clipBoard = new ArrayDeque<>();
        char last = boom.charAt(boom.length() - 1);

        // 비교용 문자열이 1자리일 경우, 그것만 다 지워줌
        if(boom.length()==1) {
            str = str.replaceAll(boom, "");
            System.out.println(str);
        }
        else {
            int now = 0;
            while (now < str.length()) {
                // dq에 남은 문자가 비교용 단어의 길이보다 짧을 때, 최소한의 비교할 만큼의 문자를 채워줌
                if (dq.size() < boom.length() - 1) {
                    while (dq.size() != boom.length()-1) {
                        dq.add(str.charAt(now));
                        now++;
                    }
                    continue;
                }

                char nowChar = str.charAt(now);
                now++;

                // 마지막 문자와 같은 것이 걸렸을 때,
                if (nowChar == last) {
                    clipBoard.push(nowChar);
                    for (int j = boom.length() - 2; j >= 0; j--) {
                        // 비교해서 일치하면 클립보드에 넣어줌
                        if (dq.peekLast() == boom.charAt(j)) {
                            clipBoard.addLast(dq.pollLast());
                            if(j==0) clipBoard = new ArrayDeque<>();
                        }
                        // 비교해서 일치하지 않으면, 클립보드에 있는애들 다 원상복귀 후, nowChar도 넣어줌
                        else {
                            while(!clipBoard.isEmpty()) dq.addLast(clipBoard.pollLast());
                            break;
                        }
                    }
                }
                else {
                    dq.add(nowChar);
                }
            }
            String result = "";
            int size = dq.size();
            for(int i=0 ; i<size ; i++) {
                result += dq.poll();
            }

            if(result.equals("")) System.out.println("FRULA");
            else System.out.println(result);
        }
    }
}