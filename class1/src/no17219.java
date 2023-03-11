import java.io.*;
import java.util.*;

public class no17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();

        for(int i=0; i<T ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            map.put(st2.nextToken(), st2.nextToken());
        }

        for(int i=0; i<M ; i++) {
            String pw = map.get(br.readLine());
            bw.write(pw+"\n");
        }

        bw.close();
    }
}