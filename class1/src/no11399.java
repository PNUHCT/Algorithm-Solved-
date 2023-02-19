import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<T ; i++) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        int time = 0;
        int num = 0;
        for(int i = list.size(); i>0 ; i--) {
            time += (list.get(num) * i);
            num++;
        }

        System.out.println(time);
    }
}