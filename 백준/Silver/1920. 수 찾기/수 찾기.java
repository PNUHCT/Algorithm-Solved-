import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> setN = new HashSet<>();
        StringTokenizer stst = new StringTokenizer(br.readLine(), " ");
        for(int i =0 ; i<N ; i++) setN.add(stst.nextToken());

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(M-->0) {
            String str = st.nextToken();
            if(setN.contains(str)) {
                bw.write("1"+"\n");
            } else {
                bw.write("0"+"\n");
            }
        }
        bw.close();
    }
}


