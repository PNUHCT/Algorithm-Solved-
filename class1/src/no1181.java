import java.io.*;
import java.util.*;

public class no1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<T ; i++) {
            String str = br.readLine();
            int length = str.length();

            map.put(str, map.getOrDefault(str, length));
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue());

        for(Map.Entry<String, Integer> entry:entryList) bw.write(entry.getKey()+"\n");

        bw.close();
    }
}

