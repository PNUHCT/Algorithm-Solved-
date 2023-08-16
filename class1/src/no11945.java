import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no11945 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i< N; i++) {
            String[] arr = br.readLine().split("");
            for(int j=arr.length-1 ; j>=0 ; j--) bw.append(arr[j]);
            bw.append("\n");
        }

        bw.close();
    }
}

