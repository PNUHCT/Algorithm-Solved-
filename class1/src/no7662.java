import java.io.*;
import java.util.*;

public class no7662 {
    private static Map<Integer, Integer> hm;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int Q;
        StringTokenizer st;
        while(T-->0) {
            Q = Integer.parseInt(br.readLine());
            hm = new HashMap<>();
            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                operation(st.nextToken(), Integer.valueOf(st.nextToken()), hm);
            }

            if (hm.isEmpty()) bw.write("EMPTY\n");
            else {
                int max = Collections.max(hm.keySet());
                int min = Collections.min(hm.keySet());
                bw.write(""+max+" "+min+"\n");
            }
        }

        bw.close();
    }

    private static void operation(String op, Integer val, Map<Integer, Integer> hm) {
        if(op.equals("I")) {
            if(hm.containsKey(val)) hm.put(val, hm.get(val)+1);
            else hm.put(val, 1);
        } else if(op.equals("D") && val.equals(1)) {
            if(hm.isEmpty());
            else {
                int max = Collections.max(hm.keySet());
                if(hm.get(max)>1) hm.put(max, hm.get(max)-1);
                else hm.remove(max);
            }
        } else {
            if(hm.isEmpty()) ;
            else {
                int min = Collections.min(hm.keySet());
                if(hm.get(min)>1) hm.put(min, hm.get(min)-1);
                else hm.remove(min);
            }
        }
    }
}