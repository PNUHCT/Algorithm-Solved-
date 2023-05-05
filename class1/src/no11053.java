import java.io.*;
import java.util.*;

public class no11053 {
    /**
     * 수열 A의 길이와, A에 들어갈 숫자가 차례로 주어진다.
     * 원래 수열에서 순차적으로 증가만 하는 부분수열 중, 가장 긴 수열의 길이를 구하시오
     */
//    private static int result=0;
//    private static List<Integer> list = new ArrayList<>();
//    private static List<Integer> subset;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//        for(int i=0; i<T ; i++) list.add(Integer.parseInt(st.nextToken()));
//
//        for(int i=0 ; i<list.size(); i++) {
//            subset = new ArrayList<>(); // 다음 수열을 구할 때 subset을 초기화 시켜준다(비워준다)
//            subset.add(list.get(i)); // 시작하기 전에 첫 번째 숫자는 넣어주자
//            DP(i, i+1);
//        }
//
//        System.out.println(result);
//    }
//
//    private static void DP (int base, int compare) {
//        if(compare>=list.size()) { // 비교할 숫자가 다음 전체 수열 길이에 도달했을 경우,
//            if(list.get(base)<list.get(compare-1)) subset.add(list.get(compare-1));
//            if(subset.size()>=result) result = subset.size();
//            return;
//        }
//        if(list.get(base)>=list.get(compare)) {
//            DP(base, compare+1); // 마지막으로 가장 컸던 위치와, 다시 확인해볼 위치로 이동
//        } else {
//            subset.add(list.get(compare));
//            DP(compare, compare+1); // 마지막으로 가장 컸던 위치는 현위치고, 다음 확인할 위치는 다음 칸으로 이동
//        }
//    }
//}

    /**
     * Chat GPT의 풀이
     *
     * 순차적으로 이중반복
     * DP는 수열의 총 길이이며, 각 위치마다 도달하며 선택할 수 있는 숫자들을 카운트
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] A = new int[n];

        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        int[] dp = new int[n]; // 수열을 담는게 아니라, 각 위치별로 도달하며 수열에 넣을 수 있는 최대 갯수를 카운트하는 배열
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {  // 구할 부분수열의 길이를 나타냄으로써, 최소 길이를 2 이상으로 확인하기 위해 1부터 시작.
            for (int j = 0; j < i; j++) { // 맨 앞부터 순차적으로 2개씩 비교하기위해 0부터 시작, 구하고자 하는 부분수열의 길이만큼 반복
                if (A[j] < A[i]) { // 앞의 숫자보다 뒤의 숫자가 더 클 경우
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 현재 도달한 위치의 카운트는, 현재 위치의 카운트와 직전 숫자까지 도달한 카운트+1중 더 높은 숫자로 업데이트
                }
            }
        }
        int maxLength = 0;
        for (int i = 0; i < n; i++) maxLength = Math.max(maxLength, dp[i]);

        System.out.println(maxLength);
    }
}