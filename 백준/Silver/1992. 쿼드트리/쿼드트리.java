import java.io.*;

public class Main {

    private static String[][] matrix;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        matrix = new String[N][N];

        for(int i = 0; i<N; i++) matrix[i] = br.readLine().split("");

        QuadTree( 0, 0, N);

        System.out.println(sb);
    }


    private static void QuadTree(int x, int y, int size) throws IOException {
        // 압축이 가능할 경우 하나의 색상으로 압축
        if(isPossible(x,y,size)) {
            sb.append(matrix[x][y]);
            return;
        }

        int newSize = size/2;

        sb.append("("); // 각 depth에서 여는 괄호로 시작하는 부분

        QuadTree(x, y, newSize);  // 1 사분면
        QuadTree(x, y+newSize, newSize); // 2 사분면
        QuadTree(x+newSize, y, newSize);  // 3 사분면
        QuadTree(x+newSize, y+newSize, newSize);  // 4 사분면

        sb.append(")"); // 각 depth에서 닫는 괄호로 끝나는 부분
    }

    private static boolean isPossible (int x, int y, int size) {
        String firstNum = matrix[x][y];

        // matrix의 각 부분을 나눠서 순회함. 시작점을 지정하고, 줄어든 사이즈만큼 반복하는 것
        for(int i = x; i< x+size; i++) {
            for(int j = y; j< y+size; j++) if(!firstNum.equals(matrix[i][j])) return false; // 만약 범위내에 첫번째 숫자와 다른 숫자가 있다면, 압축 불가능을 반환하고 반복중지
        }
        return true; // 범위를 다 돌았는데 문제없으면 압축 가능을 반환
    }
}

