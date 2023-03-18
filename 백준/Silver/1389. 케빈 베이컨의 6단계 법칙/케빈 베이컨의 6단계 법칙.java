import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    private static int node;
    private static int edge;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받는 구간 : 노드 수와 간선 수가 주어진다
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        map = new int[node+1][node+1]; // 1번부터 node번까지의 위치를 탐색하기 위함 (0번 인덱스때문)
        
        for (int i = 0; i < edge; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
            int departure = Integer.parseInt(st2.nextToken());
            int arrival = Integer.parseInt(st2.nextToken());
            map[departure][arrival] = map[arrival][departure] = 1;
        }

        // BFS 탐색을 위해 시작, 목표 지점을 정해서 반복해주는 구간
        int[] results = new int[node+1];
        results[0] = Integer.MAX_VALUE;
        for(int start = 1; start <= node; start++) {
            int sum = 0; // 시작지점에서 각 목표 지점으로 도착했을 때, 최단 거리들을 합산해주기 위한 역할
            for(int goal = 1; goal <= node; goal++) {
                if(start!=goal) sum += BFS(start, goal); // 각 지점까지 도달한 최단 거리를 반환해준 것을 합산 
            }
            results[start] = sum; // 모든 인원에 대한 최단 거리를 합한 값을 출발지점의 인덱스에 기록
        }

        // 최솟값 찾기
        int min = Integer.MAX_VALUE; // 최소값으로 비교하기 위해 기준값은 최대값으로 설정
        int answer = 0; // 최소값을 가진 인덱스를 기록하기 위함
        for(int i=results.length-1; i>0 ; i--) {  // 같은 최단거리를 가질 경우, 더 작은 인덱스에 있는 인원을 고르기 위해 역순으로 계산
            if(results[i]<=min) {
                min = results[i]; // 최소값 기록
                answer = i;  // 최소값을 가진 인덱스 기록
            }
        }

        System.out.println(answer); // 반환값은 최단거리의 합이 아닌, 해당 인원의 위치이므로 answer를 반환. (만약 총 합 거리를 원할 시 min을 반환)
    }

    private static int BFS(int start, int goal) {
        Deque<Node> dq = new ArrayDeque<>(); // 대기열
        dq.add(new Node(start, goal, 0)); // 처음 시작지점
        boolean[] visited = new boolean[node+1]; // 방문 체크
        List<Integer> tempList = new ArrayList<>(); // 도달 거리들을 기록하는 용도

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if(now.start==now.end) tempList.add(now.count);
            for(int i=1; i <= node ; i++) {
                if(map[now.start][i]==1 && !visited[i]) {
                    visited[i] = true;
                    dq.add(new Node(i,goal, now.count+1)); // 방금 도착한 지점이 곧 다음 출발지점이 됨. 이동 했으므로 직전 이동거리+1
                }
            }
        }
        return Collections.min(tempList); // 기록 중 최단거리를 구해서 반환
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
