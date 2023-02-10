import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class no18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> baseList = new ArrayList<>();
        List<Integer> sideList = new ArrayList<>();
        Map<Integer, Integer> rankMap = new HashMap<>();
        for(int i=0; i<T ; i++) {
            Integer num = Integer.parseInt(st.nextToken());
            baseList.add(num);
            sideList.add(num);
        }

        List<Integer> sortList = sideList.stream().distinct().sorted().collect(Collectors.toList());

        int rank =0;
        for(int num:sortList) {
            if(!rankMap.containsKey(num)) {
                rankMap.put(num, rank);
                rank++;
            }
        }

        for(int key:baseList) bw.append(""+rankMap.get(key)+" ");

        bw.close();
    }
}