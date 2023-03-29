import java.io.*;

public class no17626 {
    /**
     * 브루트 포스
     * 1. 1부터 제곱
     * 2. 제곱이 N보다 크면, 다음 차례로 넘어감
     * 3. 1부터 제곱 + 1부터 제곱 의 반복
     * 4. 합이 N보다 크면, 다음 차례로 넘어감
     * 5. 이런식으로 총 4개까지 진행
     * 6. 중간에 같은 수가 나오면, 제곱을 위해 더한 개수를 출력
     */

    private static double N; // 최종 목표가 될 임의로 들어오는 자연수. static 메소드에서 사용하기 위해 static 변수로 받음

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 입력받은 자연수를 static 변수에 할당해주는 구간
        System.out.println(brute()); // static 메소드를 호출해서 결과 출력
    }

    /**
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
}

