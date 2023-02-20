import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class no1931 {

    static ArrayList<Factor> list;
    static List<Factor> sortedList;

    static class Factor {
        private int start;
        private int end;
        public Factor(int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int getStart() { return this.start; }
        public int getEnd() { return this.end; }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i=0; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Factor factor = new Factor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(factor);
        }

        Comparator<Factor> compare = Comparator.comparing(Factor::getEnd).thenComparing(Factor::getStart);
        sortedList = list.stream().sorted(compare).collect(Collectors.toList());

        int count = 0;
        int endTime = 0;
        for(int i = 0 ; i < sortedList.size() ; i++) {
            if(endTime<=sortedList.get(i).getStart()) {
                endTime = sortedList.get(i).getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}