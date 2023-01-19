import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class no11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 반복 횟수와 값을 담을 ArrayList. ArrayList에 담을 객체는 이너클래스로 정의했다.
         */
        int N = Integer.parseInt(br.readLine());
        List<Factor> list = new ArrayList<>();

        /**
         * 입력된 값으로 Factor 객체를 만들어 list에 담아준다
         */
        for(int i=0; i<N ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            Factor factor = new Factor(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            list.add(factor);
        }

        /**
         * Comparator를 이용해 정렬 조건을 만들어준다.
         * 첫 정렬 조건은 comparing()으로, 다중 정렬조건은 thenComparing()으로 추가시켜준다.
         */
        Comparator<Factor> compare = Comparator
                .comparing(Factor::getY)
                .thenComparing(Factor::getX);

        /**
         * stream을 이용한 list안의 객체를 정렬해줄 것이다.
         * 이때, 정렬 조건으로 Comparator객체를 사용한다.
         */
        List<Factor> list2 = list.stream().sorted(compare).collect(Collectors.toList());

        /**
         * 출력 형식에 맞게 출력해준다.
         */
        for(int i=0; i<list.size() ; i++) {
            bw.write(""+list2.get(i).getX()+" "+list2.get(i).getY()+"\n");
        }
        bw.close();
    }

    /**
     * 이너클래스 부분
     * 좌표값이 될 X와 Y를 필드로 두고, 생성자를 이용해 Factor를 생성해 줄 것이다.
     * Comparator에서 객체 안의 값을 얻어야 하므로 get메서드를 추가로 만들어 준다.
     */
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