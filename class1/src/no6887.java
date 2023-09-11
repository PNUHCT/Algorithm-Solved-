import java.io.*;

public class no6887 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int T;

    public static void main(String[] args) throws IOException {
        // 주어진 타일의 수
        T = Integer.parseInt(br.readLine());

        // Math 라이브러리의 제곱근 구하는 메소드 sqrt()를 사용. 출력값을 int형으로 변환 시 정수 최대값이 구해짐.
        int answer = (int) Math.sqrt(T);

        // 형식에 맞게 출력
        System.out.println(String.format("The largest square has side length %d.", answer));
    }
}