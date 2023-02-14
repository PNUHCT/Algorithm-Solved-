import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static Integer node;
    static Integer edge;
    static int [][] matrix;
    static boolean [] visited; 
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        node = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        
        matrix = new int[node+1][node+1];
        visited = new boolean[node+1];
        
        // 행렬에 연결되는 노드에 1으로 체크(방향이 없으므로 양방향 1체크) 
        for(int i=0; i<edge; i++) {
            StringTokenizer edgeSt = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(edgeSt.nextToken());
            int end = Integer.parseInt(edgeSt.nextToken());
            matrix[start][end] = 1;
            matrix[end][start] = 1;
        }
        
        int count = 0;
        
        // 방문한 열을 돌면서, 안가본 정점이 있으면 탐색을 시작하고, 덩어리수 +1
        for(int i=1 ; i<=node ; i++) {
            if(!visited[i]) {
                DFS(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    private static void DFS (int start) {
        // 방문 체크
        visited[start] = true;
        
        // 방문한 행을 돌면서, 간선이 연결된 애들에 한해서, 안가본 곳이면 가봐라
        for(int i =1; i<=node ; i++) {
            if(matrix[start][i]==1 && !visited[i]) DFS(i);
        }
    }
}

