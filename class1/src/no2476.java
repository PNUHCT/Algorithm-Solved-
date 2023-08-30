import java.io.*;
import java.util.*;

/**
 * 같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
 * 같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
 * 모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.
 */
public class no2476 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayList<Integer> members = new ArrayList<>(); // 결과 값들을 담을 리스트
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        // 각 인원수별 조사 반복
        while(N-->0) {
            /**
             * 원리 :
             * 리스트에 중복될 눈이 있다면, 담지 않음
             * 다른 눈이라면 리스트에 담음
             * 리스트 사이즈에 따라, 상태는 다음과 같음
             * 리스트 사이즈 1 = 전체 중복
             * 리스트 사이즈 2 = 두개 중복
             * 리스트 사이즈 3 = 모두 다름
             *
             * 따라서, 각 케이스에 맞춰 계산 진행.
             * 이때, 중복된 눈이 있다면, 따로 메모라이즈
             */
            List<Integer> temp_list = new ArrayList<>(); // 주사위 눈을 담을 리스트

            st = new StringTokenizer(br.readLine(), " ");
            int fst = Integer.parseInt(st.nextToken());
            int sec = Integer.parseInt(st.nextToken());
            int trd = Integer.parseInt(st.nextToken());

            temp_list.add(fst); // 첫 눈금은 비교를 위해 무조건 담음
            int memory = fst;

            //두번째 눈금 비교
            if(!temp_list.contains(sec)) temp_list.add(sec);
            else memory = sec;

            //세번째 눈금 비교
            if(!temp_list.contains(trd)) temp_list.add(trd);
            else memory = trd;

            // 각 케이스별 결과 계산 후 저장
            int result;
            if(temp_list.size() == 1) result = 10000 + (memory * 1000);
            else if(temp_list.size() == 2) result = 1000 + (memory * 100);
            else result = Collections.max(temp_list) * 100;
            members.add(result);
        }

        // 결과들 중 최대값 출력
        System.out.println(Collections.max(members));
    }
}

