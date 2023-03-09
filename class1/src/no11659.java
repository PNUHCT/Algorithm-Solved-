import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class no11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 입력구간
         */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>(); // 구간합들을 받을 list
        list.add(0); // list의 0번째 인덱스를 미리 0으로 채워줌 (1부터 셀 것이기 때문에)
        for(int i = 1 ; i<=N ; i++) list.add(i, list.get(i-1) + Integer.parseInt(stN.nextToken())); // 구간 합을 순차적으로 넣어줌

        /**
         * M개의 입력에 따라 구간합들을 출력해주는 구간
          */
        while(M-->0) {
            StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
            int head = Integer.parseInt(stM.nextToken());
            int tail = Integer.parseInt(stM.nextToken());
            int result = list.get(tail) - list.get(head-1); // head번째(i번째) 수를 포함시키기 위해선 i-1번째까지의 합을 빼야함
            System.out.println(result);
        }
    }
}

