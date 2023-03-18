import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    /**
     * 케빈 베이컨의 6단계 법칙
     * : 모든 사람과 두루 가깝게 지내는 사람 구하기
     * : 즉, 다른 모든 인원과 몇 다리 걸쳐야 하는지 구한 거리수의 총합이 가장 적은사람이 케빈 베이컨
     * DFS하면서 카운트해서 제일 짧게 끝나는 경우의 시작점을 반환?
     * BFS하면서 카운트해서 제일 빨리 끝나는 경우를 사람마다 저장해서, 모든 인원 비교 후 가장 짧은 경우를 비교?
     */

    private static int node;
    private static int edge;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받는 구간 : 노드 수와 간선 수가 주어진다
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        map = new int[node+1][node+1];

        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int departure = Integer.parseInt(st2.nextToken());
            int arrival = Integer.parseInt(st2.nextToken());
            map[departure][arrival] = map[arrival][departure] = 1;
        }

        /** 1. 1번에서 N 번까지의 모든 인원을 대상으로 시작
         *  2. 1번에서 N 번까지의 모든 인원까지 가는 방법을 계산해서 합함
         *  3. 모든 인원의 합을 구한 뒤, 가장 적은 합을 가진 사람 구하기
         */
        int[] results = new int[node+1];
        results[0] = Integer.MAX_VALUE;
        for(int start = 1; start <= node; start++) {
            int sum = 0;
            for(int goal = 1; goal <= node; goal++) {
                if(start!=goal) {
                    int cnt = BFS(start, goal);
                    sum += cnt;
                }
            }
            results[start] = sum; // 모든 인원에 대한 거리를 합한 값을 입력
        }

        // 최솟값 찾기
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i=results.length-1; i>0 ; i--) {
            if(results[i]<=min) {
                min = results[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }

    private static int BFS(int start, int goal) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(start, goal, 0));
        boolean[] visited = new boolean[node+1];
        List<Integer> tempList = new ArrayList<>();

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if(now.start==now.end) tempList.add(now.count);
            for(int i=1; i <= node ; i++) {
                if(map[now.start][i]==1 && !visited[i]) {
                    visited[i] = true;
                    dq.add(new Node(i,goal, now.count+1));
                }
            }
        }
        int answer = Collections.min(tempList);

        return answer;
    }

    private static class Node {
        private int start;
        private int end;
        private int count;
        public Node(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }
    }
}
