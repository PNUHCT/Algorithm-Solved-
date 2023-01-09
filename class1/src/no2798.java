import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no2798 {
    static int max_cnt = 3;
    static int[] subset;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());
        int[] nums = new int[N];
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++) nums[i] = Integer.parseInt(st2.nextToken());

        subset = new int[N];

        Combination(nums,0, 0, M);

        System.out.println(result);
    }

    private static void Combination(int[] nums, int cnt, int k, int M) {
        if (cnt == max_cnt) {
            int sum = 0;
            for(int i = 0; i < 3 ; i++) sum += subset[i];
            if(sum<=M && result<=sum) result = sum;
            return;
        }
        for (int i = k; i < nums.length; i++) {
            subset[cnt] = nums[i];
            Combination(nums, cnt + 1, i + 1, M);
        }
    }
}

