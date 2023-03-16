import java.io.*;
import java.util.*;

public class no2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());
        List<Integer>list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);
        int max = Collections.max(list);
        int answer;

        if(first==second && second==third && third==first) answer = 10000+(first*1000);
        else if (first==second) answer = 1000+(first*100);
        else if (second==third) answer = 1000+(second*100);
        else if (first==third) answer = 1000+(third*100);
        else answer = max * 100;

        System.out.println(answer);
    }
}

