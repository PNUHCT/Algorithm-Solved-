import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T ; i++) {
            String[] arr = br.readLine().split("");
            int R = Integer.parseInt(arr[0]);
            String P = "";
            for(int k=2; k<arr.length; k++) {
                for(int j=0; j<R ; j++) {
                    P += arr[k];
                }
            }
            bw.write(P+"\n");
        }
        
        bw.close(); 
    }
}