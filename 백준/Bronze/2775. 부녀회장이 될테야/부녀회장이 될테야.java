import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        
        for(int i=0; i<T ; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            /**
             * 0부터 시작하기 때문에, k+1, n+1사이즈의 Matrix를 생성 (=아파트) -> 배열의 인덱스를 k와 n까지 하기 위함
             * 아파트는 k층과 n호까지만 세면 되기 때문에 그만큼만 생성하면 됨
             * 0층 : 맨 아래층 세팅을 하는 곳으로, 0호부터 N호까지 0,1,2,3,4,...,n으로 채워놓음 
             */
            int[][] arr = new int [k+1][n+1];
            for(int j=0; j<=n ; j++) arr[0][j] = j;
            bw.write(""+calculation(k,n,arr)+"\n");
        }
        bw.close();
    }

    /**
     * i층 j호를 구하는 이중반복을 수행할 것이다.
     * i층 j호는 i-1층의 1~n호의 인원합을 대입
     * 층수가 올라갈 때마다 합산 초기화
     * 참고 : 0호의 경우 항상 0명이며, 1호의 경우 항상 1명임
     * @param k : 목표층수
     * @param n : 목표호수
     * @param arr : 아파트를 나타내는 매트릭스로, 0층을 제외하곤 비어있는 상태
     * @return k층 n호의 인원수
     */
    private static int calculation (int k, int n, int[][] arr) {
        for(int i=1;i<=k;i++) {
            int sum = 0;
            for(int j=1;j<=n;j++){
                sum += arr[i-1][j];
                arr[i][j] = sum;
            }
        }
        return arr[k][n];
    }
}

