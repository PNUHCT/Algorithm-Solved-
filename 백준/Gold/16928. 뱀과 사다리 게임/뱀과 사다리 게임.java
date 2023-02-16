import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static Integer[] map;

    static int minDice;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new Integer[100];
        minDice = 100000;

        // 입력받아 map을 만들어줌 (1열로 나열)
        for(int i=0; i<N+M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            map[Integer.parseInt(st2.nextToken())] = Integer.valueOf(st2.nextToken());
        }

        BFS();

        System.out.println(minDice);
    }




    private static void BFS() {
        // 현위치 저장 및 반환하는 dq
        Deque<Integer> dq = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        visited[1] = dq.offer(1); // offer : add 성공시 true | 실패시 false 반환
        int dice = 0; // 주사위 롤 횟수

        while(!dq.isEmpty()) {
            dice++;
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                int now = dq.poll(); // 출발위치

                // 주사위의 1~6경우의 수
                for(int plus = 1 ; plus <=6 ; plus++) {
                    int next = now + plus;

                    // 방문한 곳이거나, 0보다 작거나, 이미 종점이면 제껴라
                    if(next < 0 || next > 100 || visited[next]) continue;

                    // 100에 도착했을 경우
                    if(next == 100) {
                        if(dice<=minDice) {
                            dq.clear();
                            minDice = dice;
                            return;
                        } else continue;
                    }

                    // 일반 칸일때
                    if(map[next] == null) {
                        dq.add(next);
                        visited[next] = true;
                    }

                    // 사다리나 뱀이 있는 칸일 경우.
                    else {
                        if(visited[map[next]]) continue; // 방문 한 칸일 경우
                        dq.add(map[next]);
                        visited[map[next]] = true;
                    }
                }
            }
        }

    }
}

