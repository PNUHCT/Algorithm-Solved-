import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;
        for(int i=0; i<T ; i++) {
            int K = Integer.parseInt(st.nextToken());
            if(K>2 && K%2==0) continue;
            for(int j = 2; j <= K; j++) {
                if(j==K) {
                    count++;
                    break;
                }
                if(K%j==0) break;
            }
        }
        System.out.println(count);
    }
}
