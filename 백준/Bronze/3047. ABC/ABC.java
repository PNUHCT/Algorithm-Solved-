import java.io.*;
import java.util.*;

/**
 * 1. 주어진 숫자를 오름차순 정렬
 * 2. 주어진 알파벳을 A=0, B=1, C=2번째 인덱스의 숫자로 하여 출력
 */
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<3 ; i++) list.add(Integer.parseInt(st.nextToken()));

        Collections.sort(list);

        String str = br.readLine();

        for(int i=0 ; i<3 ; i++) {
            switch (str.charAt(i)) {
                case 'A' : bw.write(""+list.get(0)+" "); break;
                case 'B' : bw.write(""+list.get(1)+" "); break;
                case 'C' : bw.write(""+list.get(2)+" "); break;
            }
        }

        bw.close();
    }
}