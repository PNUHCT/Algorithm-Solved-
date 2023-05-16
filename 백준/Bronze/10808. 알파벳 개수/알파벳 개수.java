import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    /**
    * 아스키 코드를 이용한 문제풀이 방법
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] answer = new int[26];

        String S = br.readLine();

        for(int i = 0 ; i<S.length(); i++) {
            char charactor = S.charAt(i);
            answer[charactor-97]++;
        }

        for(int i = 0 ; i<answer.length ; i++) {
            bw.append(""+answer[i]+" ");
        }

        bw.close();
    }
}