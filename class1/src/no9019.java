import java.io.*;
import java.util.*;

public class no9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            String result = BFS(A, B);
            bw.write(result+"\n");
        }
        bw.close();
    }

    /**
     * 탐색용 메소드
     */
    private static String BFS(int A, int B) {
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[100000]; //방문 체크 배열
        String[] cmd = new String[100000]; // 명령어를 담는 배열

        dq.add(A);
        visited[A] = true;
        Arrays.fill(cmd, ""); // 배열을 초기화. 안하면 null 값으로 채워지게 됨

        while(!dq.isEmpty() && !visited[B]) {
            int now = dq.poll();

            int D = now * 2 % 10000;
            int S = now==0 ? 9999 : now-1;
            int L = (now%1000)*10 + now/1000;
            int R = (now%10)*1000 + now/10;
            if(!visited[D]) {
                dq.add(D);
                visited[D] = true;
                cmd[D] = cmd[now] + "D";
            }

            if(!visited[S]) {
                dq.add(S);
                visited[S] = true;
                cmd[S] = cmd[now] + "S";
            }

            if(!visited[L]) {
                dq.add(L);
                visited[L] = true;
                cmd[L] = cmd[now] + "L";
            }

            if(!visited[R]) {
                dq.add(R);
                visited[R] = true;
                cmd[R] = cmd[now] + "R";
            }
        }
        return cmd[B];
    }
}