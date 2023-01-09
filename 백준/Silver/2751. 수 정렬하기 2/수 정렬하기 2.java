import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<T ; i++) list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        for(int i=0 ; i<list.size(); i++) bw.write(""+list.get(i)+"\n");

        bw.close();
    }
}
