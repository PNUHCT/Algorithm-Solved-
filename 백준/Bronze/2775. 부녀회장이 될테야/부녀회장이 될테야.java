import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int [k+1][n+1];
            for(int j=0; j<=n ; j++) {
                arr[0][j] = j;
            }
            bw.write(""+calculation(k,n,arr)+"\n");
        }
        bw.close();
    }

    private static int calculation (int k, int n, int[][] arr) {
        for(int i=1;i<=k;i++) {
            int sum = 0;
            for(int j=1;j<=n;j++){
                sum += arr[i-1][j];
                arr[i][j] = sum;
            }
        }
        return arr[k][n];
    }
}

