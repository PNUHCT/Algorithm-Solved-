import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2448 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static char[][] tree;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());  // N = 3 * 2^k
        tree = new char[N][N*2-1]; // 캔버스 사이즈는 N
        for(int i=0 ; i<N ; i++) Arrays.fill(tree[i], ' '); // 우선 캔버스를 다 공백으로 채움(별 사이는 전부 공백이므로)

        // 실질적인 별찍기를 위한 재귀 메소드
        make_tree(0, N-1, N);  // 세로 좌표는 0부터, 가로 좌표는 N-1인 중간부터 찍기 시작함


        // 결과가 입력된 배열을 순회하며 출력에 담음
        for(int i=0 ; i< N ; i++) {
            for(int j=0 ; j< N*2-1 ; j++) {
                bw.append(tree[i][j]);
            }
            bw.write("\n");
        }

        bw.close();
    }

    private static void make_tree (int y, int x, int N) {
        // 최소 삼각형까지 쪼갰을 때, 삼각형으로 별 찍어줌
        if(N==3) {
            tree[y][x] = '*'; // 최소 삼각형의 첫 번째 줄
            tree[y+1][x-1] = tree[y+1][x+1] = '*'; // 최소 삼각형의 두 번째 줄
            tree[y+2][x-2] = tree[y+2][x-1] = tree[y+2][x] = tree[y+2][x+1] = tree[y+2][x+2] ='*'; // 최소 삼각형의 세 번째 줄
        }
        // 쪼갤 수 있는 삼각형인 경우, 쪼갬
        else {
            int cut = N/2;  // 만약 3개의 삼각형으로 쪼갤 수 있는 큰 삼각형인 경우, 쪼개버림
            make_tree(y,x,cut);  // 위쪽 삼각형
            make_tree(y+cut, x-cut , cut);  // 왼쪽 삼각형
            make_tree(y+cut, x+cut , cut);  // 오른쪽 삼각형
        }
    }
}

