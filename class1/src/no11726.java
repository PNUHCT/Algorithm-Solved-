import java.io.*;

public class no11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        System.out.println(tiling(T));
    }

    /**
     * 사실 겉보기엔 타일에 대한 조합을 구하는 것 같지만, 경우의 수를 나열해보면 피보나치 수열이다.
     * 따라서, DP문제이다.
     * @param num
     * @return
     */
    public static int tiling(int num) {
        if(num==1) return 1;
        int [] arr = new int[num];
        arr[0] = 1;
        arr[1] = 2;

        for(int i=2 ; i < num ; i++ ){
            arr[i] = (arr[i-1] + arr[i-2])%10007;
        }
        return arr[num-1];
    }
}

