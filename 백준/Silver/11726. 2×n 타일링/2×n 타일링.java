import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        System.out.println(tiling(T));
    }

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