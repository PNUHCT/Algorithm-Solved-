import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] A = new String[N][M];
        String[][] B = new String[N][M];

        for(int i=0; i<N ; i++) {
            String[] arr = br.readLine().split(" ");
            A[i] = arr;
        }
        for(int i=0; i<N ; i++) {
            String[] arr = br.readLine().split(" ");
            B[i] = arr;
        }

        for(int i=0; i<N ; i++) {
            for(int j=0; j<M ; j++) {
                int temp = Integer.parseInt(A[i][j]) + Integer.parseInt(B[i][j]);
                bw.write(""+temp+" ");
                if(j==M-1) bw.write("\n");
            }
        }

        bw.close();
    }
}