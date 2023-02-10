import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        List<Integer> baseList = new ArrayList<>();
        List<Integer> sideList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<T; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            baseList.add(num);
            sideList.add(num);
        }

        List<Integer> sortList = sideList.stream().sorted().collect(Collectors.toList());

        int rank = 0;
        for(int num:sortList) {
            if(!map.containsKey(num)) {
                map.put(num, rank);
                rank++;
            }
        }

        for(int key:baseList) bw.append(""+map.get(key)+" ");

        bw.close();
    }
}