package class1.src;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class no1697 {
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        if(N>=K) System.out.println(N-K); // 만약 출발점이 목표점보다 크면 무조건 -1의 반복으로만 도달할 수 밖에 없음
        else System.out.println(BFS(N, K));
    }

    private static int BFS (int start, int goal) {
        Deque<Integer> dq = new ArrayDeque<>();
        int[] count = new int[100001];  // 수빈이가 움직일 수 있는 최대 지점까지 인덱스

        dq.add(start);
        count[start] = 1;

        // 한 번에 많은 연산을 하지 않도록, 각각의 경우를 dq에 넣고 계산.
        // dq.isEmpty() = true이면, 모든 탐색이 끝난 것
        // 중간에 목표값과 같은 값이 나오면, 가장 적은 수의 움직임을 count한 경우이므로, 해당 지점에서 return으로 종료가능
        while(!dq.isEmpty()) {
            int now = dq.poll();

            // 3가지 경우를 계산
            for(int i = 0 ; i<3 ; i++) {
                int next;

                if(i==0) next = now - 1;
                else if(i==1) next = now + 1;
                else next = now * 2;

                if(next == goal) return count[now]; // subin배열의 인자는 곧 count. 첫번째에 이미 1을 넣고 시작했으므로, next까지 카운트 된 상태

                // now를 next로 업데이트 해주며, count 배열의 count를 1씩 올려주는 구간
                // 수빈이의 최대 이동거리는 100000까지이므로, 그 안에서 해결
                if(0 <= next && next <= 100000) {
                    if(count[next] == 0) {
                        dq.add(next);
                        count[next] = count[now] + 1;
                    }
                }
            }
        }
        return 0;
    }
}

