import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        List<Factor> list = new ArrayList<>();

        for(int i=0; i<N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Factor factor = new Factor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(factor);
        }

        Comparator<Factor> compare = Comparator
                .comparing(Factor::getX)
                .thenComparing(Factor::getY);

        List<Factor> list2 = list.stream().sorted(compare).collect(Collectors.toList());

        for(int i=0; i<list.size() ; i++) {
            bw.write(""+list2.get(i).getX()+" "+list2.get(i).getY()+"\n");
        }
        bw.close();

    }

    static class Factor {
        private int X;
        private int Y;

        public Factor(Integer X, Integer Y) {
            this.X = X;
            this.Y = Y;
        }

        public int getX() {
            return this.X;
        }

        public int getY() {
            return this.Y;
        }
    }
}