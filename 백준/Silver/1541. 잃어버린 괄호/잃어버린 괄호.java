import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 1. '-'를 기준으로 전부 나눠서 저장 : -기준으로 나눈 값들은 전부 +이므로, 총 합을 맨 첫 숫자에서 빼주면 최소값이 됨
         * 2. '+'로 나눠서 전부 합해줌
         * 3. 맨 첫번째 합산에서 나머지 뒤의 합산을 전부 빼줌
         */
        String[] forMinus = br.readLine().split("-");
        int head = 0;
        int tails = 0;
        for(int i = 0 ; i<forMinus.length; i++) {
            int temp = 0;
            if(forMinus[i].contains("+")) {
                String tempStr = forMinus[i];
                String[] forPlus = tempStr.split("[^A-Z0-9]+|[^0-9$]");
                for(int j =0; j<forPlus.length; j++) {
                    temp+=Integer.parseInt(forPlus[j]);
                }
            } else temp += Integer.parseInt(forMinus[i]);

            if(i==0) head = temp;
            else tails+=temp;
        }
        System.out.println(head - tails);
    }
}