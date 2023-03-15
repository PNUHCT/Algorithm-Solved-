import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<3 ; i++) list.add(Integer.parseInt(st.nextToken()));
        list.sort(Comparator.naturalOrder());
        for(int result: list) bw.write(""+result+" ");
        bw.close();
    }
}