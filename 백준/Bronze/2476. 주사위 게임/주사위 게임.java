import java.io.*;
import java.util.*;

/**
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
 * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
 */
public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayList<Integer> members = new ArrayList<>();
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i< N; i++) {
            List<Integer> temp_list = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int trd = Integer.parseInt(st.nextToken());
            temp_list.add(fst);
            int memory = fst;
            if(!temp_list.contains(sec)) temp_list.add(sec);
            else memory = sec;
            if(!temp_list.contains(trd)) temp_list.add(trd);
            else memory = trd;

            int result;
            if(temp_list.size() == 1) result = 10000 + (memory * 1000);
            else if(temp_list.size() == 2) result = 1000 + (memory * 100);
            else result = Collections.max(temp_list) * 100;
            members.add(result);
        }

        System.out.println(Collections.max(members));
    }
}