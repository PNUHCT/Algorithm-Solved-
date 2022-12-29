import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        String str = "";
        
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<T; i++) {
            int A = Integer.parseInt(st2.nextToken());
            if(A<X) str += A + " ";   
        }

        bw.write(str);
        bw.close();
    }
}
