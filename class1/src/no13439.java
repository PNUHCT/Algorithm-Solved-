import java.util.*;
import java.io.*;

public class no13439 {
    /**
     * 주어진 두개의 숫자 중,
     * 시작 숫자가 목표숫자에 도달할 때까지 걸리는 시간을 출력하기
     * 조건1. 1초에 +1 or -1가능
     * 조건2. 시간 추가없이 *2 무한정 가능
     */

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[] visited = new boolean[2000001]; // 둘다 최대는 100000이므로;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sb = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        if(sb==goal) System.out.println(0);
        else if (sb>goal) System.out.println(sb-goal);
        else {
            /**
             * 0. 현재숫자 == 목표숫자면 종료
             * 1. -1을 수행, sec++  => 반복
             * 2. +1을 수행, sec++  => 반복
             * 3. *2를 수행         => 반복
             */
            if(sb==0) sb++; // 8% 에서 실패하는 경우, 수빈이의 첫 위치가 0일 때를 산정하기
            System.out.println(calcul(sb, goal));
        }
    }    

    private static int calcul (int sb, int goal) {
        Deque<Subin> dq = new ArrayDeque<>();
        dq.add(new Subin(sb, 0));
        int result = Integer.MAX_VALUE;
        
        while(!dq.isEmpty()) {
            Subin subin = dq.poll();

            if(subin.Now == goal && result>=subin.Sec) result = subin.Sec;
            // if(subin.Now == goal) {
            //     result = subin.Sec;
            //     break;
            // }
            
            if(subin.Now>0 && subin.Now <=100000 && !visited[subin.Now]) {
                visited[subin.Now] = true;
                dq.add(new Subin(subin.Now-1, subin.Sec+1));
                dq.add(new Subin(subin.Now+1, subin.Sec+1));
                dq.add(new Subin(subin.Now*2, subin.Sec));
                }
        }
        return result;
    }

    private static class Subin {
        private int Now;
        private int Sec;

        public Subin (int now, int sec) {
            this.Now = now;
            this.Sec = sec;
        }
    } 
}
