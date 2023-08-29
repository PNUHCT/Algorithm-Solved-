import java.io.*;
import java.util.StringTokenizer;

public class no1547 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T;
    private static StringTokenizer st;
    private static boolean[] arr = {true, false, false};

    public static void main(String[] args) throws IOException {

        // 컵 교환 수 입력
        T = Integer.parseInt(br.readLine());

        // 컵 교환 반복
        while(T-->0) {
            st = new StringTokenizer(br.readLine(), " ");
            int X = Integer.parseInt(st.nextToken()) - 1;  // arr의 0, 1 ,2번째 == 실제 컵 1, 2, 3번째 이므로
            int Y = Integer.parseInt(st.nextToken()) - 1;  // 인덱스와 컵 위치의 차이인 -1만큼 해줌

            change(X, Y); // 컵 교환 위임
        }

        // 컵 교환 완료 후 최종적으로 true인 곳이 공의 위치
        for(int where=0; where<arr.length; where++) {
            if(arr[where]) {
                System.out.println(where + 1);
                break;
            }
        }
    }

    // 컵 위치 교환 메소드
    private static void change(int X, int Y) {
        boolean A = arr[X];
        boolean B = arr[Y];

        arr[X] = B;
        arr[Y] = A;
    }
}