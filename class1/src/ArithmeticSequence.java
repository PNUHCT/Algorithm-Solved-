public class ArithmeticSequence {

    public static void main(String[] args) {
        System.out.println(solution(5, 5));
    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];

        int sum = num * (1 + num) / 2; // num개의 수를 공차 1로 합산한 수
        int start = (total - sum) / num;  // 실제 시작점. 음수일 경우를 포함한 등차수열의 합은 num개의 합산만큼 뺀 수에서 구
        for (int i = 0; i < num; i++) {
            answer[i] = i + 1 + start;
        }

        return answer;

    }
}
