import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> numMap = new HashMap<>();
        Map<String, String> nameMap = new HashMap<>();
        int count = 1;
        while(N-->0) {
            String cnt = String.valueOf(count);
            String pokemon = br.readLine();
            numMap.put(cnt, pokemon);
            nameMap.put(pokemon, cnt);
            count++;
        }
        
        while(M-->0) {
            String pokemon = br.readLine();
            if(numMap.containsKey(pokemon)) bw.write(numMap.get(pokemon)+"\n"); // 주어진게 숫자일 경우
            else bw.write(nameMap.get(pokemon)+"\n");  // 주어진게 문자일 경우
        }
        
        bw.close();
    }
}