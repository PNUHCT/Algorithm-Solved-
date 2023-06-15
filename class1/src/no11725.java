import java.io.*;
import java.util.*;

public class no11725 {
    private static int N;
    private static boolean[][] map, visit;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        for(int i=0 ; i<N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int low = Integer.parseInt(st.nextToken());
            int cul = Integer.parseInt(st.nextToken());
            map[low][cul] = true;
        }

        for(int goal=1 ; goal<=N ; goal++) BFS(goal);

        bw.close();
    }

    private static void BFS (int goal) {
        Deque<Node> dq = new ArrayDeque<>();
        visit = new boolean[N+1][N+1];
        for(int i=2 ; i<=N ; i++) {
            for(int j=2 ; j<=N ; j++) {
                if(i==1 && map[i][j]) {
                    dq.add(new Node(1, j));
                    visit[1][j] = true;
                }
                if(j==1 && map[i][j]) {
                    dq.add(new Node(1, i));
                    visit[1][i] = true;
                }
            }
        }

        while(!dq.isEmpty()) {
            Node now = dq.poll();
            if(now.Child==goal) bw.write(""+now.Parent+"\n");
            break;

            for(int next=1 ; next<=N ; next++) {
                if(map[now.Child][next]) {
                    visit[now.Child][next] = true;
                    dq.add(new Node(now.Child, next));
                }
                if(map[next][now.Child]) {
                    visit[next][now.Child] = true;
                    dq.add(new Node(now.Child, next));
                }
            }
        }    
    }

    private static class Node {
        private int Parent, Child;
        public Node(int parent, int child) {
            this.Parent = parent;
            this.Child = child;
        }
    }
}