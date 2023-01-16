import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int A = first(N, strArr, "1");
        int B = first(N, strArr, "2");

        int max1 = maxCount(A, "1", N, strArr, 1);
        int max2 = maxCount(B, "2", N, strArr, 1);

        int result = Math.max(max1, max2);
        System.out.println(result);
    }

    private static int first (int N, String[] strArr, String RL) {
        int num = 0;
        for(int i = 0; i<N;i++) {
            if(strArr[i].equals(RL)) {
                num = i;
                break;
            }
        }
        return num;
    }

    private static int maxCount (int A, String goal, int N, String[] strArr, int max) {
        int count = 0;
        for (int i=A;i<N;i++) {
            count = (strArr[i].equals(goal)) ? count+1 : count-1;
            if(count<0) count=0;
            else if(count>max) max = count;
        }
        return max;
    }
}