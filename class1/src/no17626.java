import java.io.*;

public class no17626 {
    /**
     * DP
     * 1. 합산한 숫자를 넣어둘 배열을 만듦. 이때, 참조변수타입으로 만들면 전부 null로 초기화됨
     * 2. 반복을 하면서 해당 자리가 null이 아닌 경우엔 이미 알아봤던 합산이므로 계산하지 않고 넘김
     */

    private static double N; // 최종 목표가 될 임의로 들어오는 자연수. static 메소드에서 사용하기 위해 static 변수로 받음
    private static Double[] DP; // DP용 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 입력받은 자연수를 static 변수에 할당해주는 구간
        DP = new Double [50001]; // 문제에서 제한이 N <= 50000

        System.out.println(brute()); // static 메소드를 호출해서 결과 출력
        System.out.println(DP());
    }

    /**
     * 합산 후, 만약 방문한 적이 없는 경우에만 DP 배열에 값을 입력 후(이제 null이 아니게 됨)
     * 목표값(N)과 비교하는 if문을 적용
     * @return 사용한 숫자의 개수
     */
    private static int brute () {
        int result = 4; // 3번의 반복을 수행하고도 안되면 나머진 전부 4개 쓴거임
        int sqrtN = (int) Math.sqrt(N); // 반복은 최대 N의 제곱근까지임. 그 이상은 N을 넘어가므로

        // * 주의할 점 : 0부터 N제곱근과 같은 숫자까지 반복해야함. (0은 안쓴경우, first < sqrtN은 sqrtN이 포함 안되므로 주의)
        for(int third = 0; third <= sqrtN; third++) {
            for(int second = 0; second <= sqrtN; second++) {
                for(int first = 0; first <= sqrtN; first++) {
                    double sum = Math.pow(first, 2) + Math.pow(second, 2) + Math.pow(third, 2);
                    DP[(int) sum] = sum;
                    if(sum==N) {  // 각 제곱의 합이 N에 도달했을 때,
                        if(third!=0) return 3; // 3개까지 썼을 경우
                        else if (second!=0) return 2; // 2개까지 썼을 경우
                        else return 1; // 1개만 썼을 경우
                    }
                }
            }
        }
        return result;
    }


    /**
     * @return 사용한 숫자의 개수
     */
    private static int DP () {
        int result = 4; // 3번의 반복을 수행하고도 안되면 나머진 전부 4개 쓴거임
        int sqrtN = (int) Math.sqrt(N); // 반복은 최대 N의 제곱근까지임. 그 이상은 N을 넘어가므로

        // * 주의할 점 : 0부터 N제곱근과 같은 숫자까지 반복해야함. (0은 안쓴경우, first < sqrtN은 sqrtN이 포함 안되므로 주의)
        for(int third = 0; third <= sqrtN; third++) {
            for(int second = 0; second <= sqrtN; second++) {
                for(int first = 0; first <= sqrtN; first++) {
                    double sum = Math.pow(first, 2) + Math.pow(second, 2) + Math.pow(third, 2);
                    if(sum<=50000 && DP[(int) sum]==null) {
                        DP[(int) sum] = sum;
                        if (sum == N) {  // 각 제곱의 합이 N에 도달했을 때,
                            if (third != 0) return 3; // 3개까지 썼을 경우
                            else if (second != 0) return 2; // 2개까지 썼을 경우
                            else return 1; // 1개만 썼을 경우
                        }
                    }
                }
            }
        }
        return result;
    }
}

