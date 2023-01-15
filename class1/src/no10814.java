import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no10814 {
    // 매트릭스와 Comparator를 이용한 sort 방법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        String[][] matrix = new String[T][2];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            matrix[i][0] = st.nextToken();
            matrix[i][1] = st.nextToken();
        }
        Arrays.sort(matrix, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
            } else {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });

        for(int i = 0;i<T;i++) {
            bw.write(matrix[i][0]+" "+matrix[i][1]+"\n");
        }

        bw.close();
    }

    // LinkedHashMap을 이용한 Sort방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int T = Integer.parseInt(br.readLine());
//
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
//
//        for(int i=0; i<T ; i++) {
//            String key = br.readLine();
//            StringTokenizer st = new StringTokenizer(key, " ");
//            Integer value = Integer.valueOf(st.nextToken());
//            map.put(key, value);
//        }
//
//        List<Map.Entry<String, Integer>> result = sortMapByKey(map);
//
//        for (Map.Entry<String, Integer> entry : result) {
//            bw.write(entry.getKey()+"\n");
//        }
//
//        bw.close();
//    }
//
//    private static List<Map.Entry<String, Integer>> sortMapByKey(Map<String, Integer> map) {
//        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
//        Collections.sort(entries, (a, b) -> a.getValue().compareTo(b.getValue()));
//
//        return entries;
//    }
}