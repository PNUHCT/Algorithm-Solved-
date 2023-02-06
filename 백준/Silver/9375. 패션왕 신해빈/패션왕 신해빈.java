import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 사실 옷의 이름은 중요하지 않다.
         * 각 타입별 몇개씩 존재하는지가 중요
         */
        int T = Integer.parseInt(br.readLine());
            
        // 테스트 케이스별 반복
        for(int i=0; i<T ; i++) {
            int M = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>(); // 각 타입별 옷을 넣을 맵
            
            // 옷 담기
            for(int j=0; j<M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // 이름은 중요치 않음
                String type = st.nextToken(); // 중요한건 타입별 몇개씩 있느냐
                map.put(type, map.getOrDefault(type, 0) + 1); // 해당 타입에 든게 있으면 +1, 없으면 0 +1 시작
            }
            
            int style = 1;
            for(int value : map.values()) style *= value + 1;

            System.out.println(style - 1);
        }
    }
}

