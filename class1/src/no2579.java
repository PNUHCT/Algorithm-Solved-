import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2579 {

    /**
     * DP를 이용한 풀이 방식
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] map = new int[T+1];
        for(int i=1; i<=T; i++) map[i] = Integer.parseInt(br.readLine());

        int[] DP = new int[T+1]; // i번째 까지의 합을 기록할 배열
        DP[1] = map[1]; // DP로 기록할 배열 초기화 과정
        if(T>=2) DP[2] = map[1] + map[2]; // 주어진 입력이 2개 이상일 경우. DP에서 연속된 3계단을 판단하기 위해선 기본 3칸은 필요(0,1,2)

        for(int now=3 ; now<=T ; now++) {
            DP[now] = Math.max(DP[now-2], DP[now-3] + map[now-1]) // 현재 칸 전에 있는 세 칸중, 첫번째칸+세번째칸 값이 두번째 값 칸보다 커야지 연속될 가치가 있는 것
                    + map[now]; // 현재 칸의 값을 합쳐줌
        }

        System.out.println(DP[T]); // 최대값이 저장 된 마지막칸을 출력
    }

    /**
     * BFS를 이용한 풀이 방식
     */
//    private static int T;
//    private static List<Integer> results = new ArrayList<>();
//    private static int[] steps;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 입력 받기
//        T = Integer.parseInt(br.readLine());
//        steps = new int[T+1];
//        for (int i = 1; i <= T; i++) steps[i] = Integer.parseInt(br.readLine());
//
//        System.out.println(BFS());
//    }
//
//    private static int BFS() {
//        Deque<Move> dq = new ArrayDeque<>();
//        dq.add(new Move(0, 0, 0)); // 첫 번째 칸은 계단으로 안침
//
//        while (!dq.isEmpty()) {
//            Move now = dq.poll();
//
//            // 3연속 계단 밟기 제외시키기 -> Move객체에 count넣기 -> count가 2일때, level+movig[i]가 T보다 작거나 같은 경우 +2로 올라감
//            for (int moving = 1; moving <= 2; moving++) {
//                // 다음 계단이 범위를 벗어 나지 않을 때
//                if(now.Level+moving<=T) {
//                    // 한번 더 연속이면 3번 연속인 상황
//                    if(now.Count==2) {
//                        if(now.Level+2 == T) results.add(now.Sum + steps[now.Level+2]);
//                        else if(now.Level+2<T) dq.add(new Move(now.Level+2, now.Sum+steps[now.Level+2], 1));
//                    }
//                    // 다음 계단이 연속이어도 되는 상황
//                    else {
//                        int nextLevel = now.Level+moving;
//                        int nextSum = now.Sum + steps[now.Level+moving];
//
//                        int nextCount;
//                        if(moving==1) nextCount = now.Count+1; // 만약 1칸 전진 일 땐, 1연속 추가
//                        else nextCount = 1;  // 만약 2칸 전진 일 땐, 연속초기화
//
//                        if(now.Level+moving == T) results.add(nextSum); // 현재까지 합 + 마지막칸 숫자
//                        else dq.add(new Move(nextLevel, nextSum, nextCount)); // 다음칸 전진, 다음칸만큼 합, 연속수
//                    }
//                }
//            }
//        }
//        return Collections.max(results);  // 나올 수 있는 모든 합중 가장 큰 수를 반환
//    }
//
//    private static class Move {
//        private int Level;
//        private int Sum;
//        private int Count;
//
//        public Move(int level, int sum, int count) {
//            this.Level = level;
//            this.Sum = sum;
//            this.Count = count;
//        }
//    }
}