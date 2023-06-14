import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class no11725 {
    private static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];
        for(int i=0 ; i<N-1 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int low = Integer.parseInt(st.nextToken());
            int cul = Integer.parseInt(st.nextToken());
            map[low][cul] = true;
        }

        OUTER : for(int i=2 ; i<=N ; i++) {
            for(int j=1 ; j<=N ; j++) {
                if(map[i][j]) {
                    bw.write(""+j+"\n");
                    continue OUTER;
                }
                if(map[j][i]) {
                    bw.write(""+j+"\n");
                    continue OUTER;
                }
            }
        }

        bw.close();
    }
}

