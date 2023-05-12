import java.io.*;
import java.util.*;

public class no12851 {

     private static int X;
     private static int K;
     private static int sec = Integer.MAX_VALUE;
     private static int cnt = 0;
     private static int[] visited = new int[100001]; // 단순 방문체크가 아닌, 방문 했을 떄 시간을 비교하기 위해 int형으로 사용
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 만약 X가 K보다 크면, 최소루트는 -1을 반복하는 방법밖에 없음
        if(X>=K) {
            System.out.println(X-K + "\n" + 1);
            return;
        }
        
        // X가 K보다 작은 경우
        BFS();

        bw.write(""+sec+"\n");
        bw.write(""+cnt+"\n");

        bw.close();
    }

    /**
     * 최소 시간을 구하는 BFS
     */
    private static void BFS() {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(X);
        visited[X] = 1;

        while(!dq.isEmpty()) {
            int now = dq.poll();
            
            // 현재 방문 시간이 최소시간보다 큰데 아직 도착을 못했으면, 이미 최소가 아닌거임
            if(sec < visited[now]) return;
            
            // 각 연산방식을 순차적으로 적용해 주기 위한 반복문
            for(int i=0 ; i<3 ;i++) {
                int next = 0;
                if(i==0) next = now - 1;
                else if(i==1) next = now + 1;
                else next = now * 2;
                
                if(next<0 || next> 100000) continue; // 범위를 벗어나면 제낌

                if(next == K) {
                    sec = visited[now]; // 처음 K에 도달한 경우 최소시간이 대입되며, 그 이후는 이미 위에서 최소시간을 넘어가는 경우에서 걸러짐
                    cnt++; // 이후 같은 시간안에 도착하는 경우마다 cnt++;
                }

                // 만약 첫 방문이거나, 다른 경우랑 중복도착했더라도 같은 시간이 걸린 경우 (중복을 허용해 주어야 하는 경우)
                if(visited[next] == 0 || visited[next] == visited[now] + 1) {
                    dq.add(next); // 다음 계산 해준다.
                    visited[next] = visited[now] + 1; // 다음 방문할 곳에 경과한 시간을 체크해 주며, 최소시간일 때로 유지된다.
                } 
            }
            

        }
    }
}