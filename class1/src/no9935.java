import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class no9935 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<Character> dq;
    private static String str, boom;

    public static void main(String[] args) throws IOException {
        // 탐색할 문자열
        str = br.readLine();
        // 필터링 할 단어
        boom = br.readLine();
        int size = boom.length();
        // 남는 단어 넣을 기본 배열
        dq = new Stack<>();
        /* 비교군 비울 배열
        1. 필터링 할 단어의 역순으로 순차적으로 비교해서 일치하면 담음
        2. 만약 모두 일치하면 비우기
        3. 만약 중간에 일치하지 않으면 다시 원위치 시킴
        */


        // 비교용 문자열이 1자리일 경우, 그것만 다 지워주고 출력 (끝)
        if(boom.length()==1) {
            str = str.replaceAll(boom, "");
            System.out.println(str);
        }
        // 그 외의 경우
        else {
            for(int i=0; i<str.length(); i++) {
                dq.push(str.charAt(i));

                // 폭발 문자열과 길이가 같아지면 탐색 시작
                if(dq.size()>= size) {
                    boolean flag = true;

                    // st.size-regexSize부터 ~ st.size까지 탐색하여 regex와 일치하면 제거
                    for(int j=0; j<size; j++) {
                        if(dq.get(dq.size()-size+j) != boom.charAt(j)) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag) {
                        for(int j=0; j<size; j++) {
                            dq.pop();
                        }
                    }
                }

            }

            StringBuilder sb = new StringBuilder();
            for(Character c : dq) {
                sb.append(c);
            }
            System.out.println(sb.length()==0? "FRULA" : sb.toString());
        }
    }
}