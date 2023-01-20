import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class no10989 {
    /**
     * Arraylist를 이용한 Collections Sort
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<T ; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        for(Integer num : list) bw.write(""+num+"\n");

        bw.close();
    }
}

