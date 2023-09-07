import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static int[][] map;
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        map = new int[9][9];
        for(int i=0; i<9 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<9 ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        bw.write(""+max+"\n");

        boolean check = false;

        for(int i = 0 ; i < 9 ; i++) {
            for(int j = 0 ; j <9 ; j++) {
                if(map[i][j]==max) {
                    bw.write("" + (i+1) + " " + (j+1) );
                    check = true;
                    break;
                }
            }
            if (check) break;
        }

        bw.close();
    }
}