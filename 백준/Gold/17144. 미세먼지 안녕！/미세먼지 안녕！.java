import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Main {
 
    static int R, C, T, map[][];
    static int cleaner = -1;
    static Queue<Dust> dusts;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static class Dust {
        int x, y, w;
 
        public Dust(int x, int y, int w) {
            super();
            this.x = x;
            this.y = y;
            this.w = w;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken()); // 행
        C = Integer.parseInt(st.nextToken()); // 열
        T = Integer.parseInt(st.nextToken()); // 초
        map = new int[R][C];
        
        // map 정보 저장
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                // 공기청정기 위치 저장    
                if(cleaner == -1 && map[i][j] == -1) {
                    cleaner = i;
                }
            }
        }
        
        for (int time = 0; time < T; time++) {
            
            // 미세먼지가 있는 공간 확인
            checkDust();
            
            // 미세먼지 확산
            spread();
            
            // 공기청정기 작동
            operate();
 
        }
        
        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1) continue;
                res += map[i][j];
            }
        }
        
        System.out.println(res);
    }
 
    private static void checkDust() {
        
        dusts = new LinkedList<>();
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1 || map[i][j] == 0) continue;
                // 미세먼지가 있는 공간과 미세먼지 양
                dusts.add(new Dust(i, j, map[i][j]));
            }
        }
        
    }
 
    private static void spread() {
        
        while(!dusts.isEmpty()) {
            
            Dust now = dusts.poll();
            // 확산될 먼지가 없으면
            if(now.w < 5) continue;
            // 확산되는 양은 Ar,c/5
            int amountOfSpread = now.w / 5;
            int cnt = 0;
            // 인접한 방향으로 확산
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];
                // 범위를 벗어나면
                if(xx < 0 || xx >= R || yy < 0 || yy >= C) continue;
                // 공기청정기가 있으면
                if(map[xx][yy] == -1) continue;
                
                map[xx][yy] += amountOfSpread;
                ++cnt;
            }
            
            // 남은 미세먼지 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수)
            map[now.x][now.y] -= amountOfSpread * cnt;
        }
        
    }
 
    // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동
    private static void operate() {
        
        int top = cleaner;
        int down = cleaner + 1;
        
        // 위쪽 공기청정기의 바람은 반시계방향 순환,
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) 
            map[i][0] = map[i-1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[0][i] = map[0][i+1];
        // 위로 당기기
        for (int i = 0; i < top; i++) 
            map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[top][i] = map[top][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[top][1] = 0;
        
        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++) 
            map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            map[R - 1][i] = map[R - 1][i + 1]; 
        // 아래로 당기기
        for (int i = R - 1; i > down; i--) 
            map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            map[down][i] = map[down][i - 1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        map[down][1] = 0;
    }
    
}