import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class no11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<N ; i++) list.add(Integer.parseInt(br.readLine()));
        List<Integer> sortedList = list.stream().sorted(Comparator.reverseOrder()).toList();
        int count = 0;
        for(int i=0; i<sortedList.size(); i++) {
            if(sortedList.get(i)<=K) {
                count += K/sortedList.get(i);
                K %= sortedList.get(i);
            }
        }
        System.out.println(count);
    }
}