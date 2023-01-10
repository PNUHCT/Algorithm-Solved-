import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class no10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String str = st.nextToken();
            if(hm.containsKey(str)) hm.put(str , hm.get(str)+1);
            else hm.put(str, 1);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M ; i++) {
            String temp = st2.nextToken();
            if(hm.containsKey(temp)) sb.append(hm.get(temp) + " ");
            else sb.append("0 ");
        }

        System.out.println(sb);
    }
}

