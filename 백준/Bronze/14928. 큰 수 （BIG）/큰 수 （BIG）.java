import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine(); // 입력 값

        long remainder = 0; // 나머지를 저장할 값
        for(int i = 0 ; i<input.length(); i++) {
            remainder = (remainder * 10 + (input.charAt(i) - '0')) % 20000303;
        }
        System.out.println(remainder);
    }
}