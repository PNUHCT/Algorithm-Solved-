import java.io.*;
import java.util.*;

public class no1157 {

    public static void main(String[] args) throws IOException {
        // 콘솔 입력용 리터럴. Scanner와 유사함. 단, Buffer특성과 String으로 고정 형변화이라는 특징으로 조금더 빠를수 있음.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 콘솔 출력용 리터럴. system.out.println과 유사하므로 필요에 따라 바꿔가면서 사용.
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int[] count = new int[26];
        String input = br.readLine();

        // 카운팅
        for(int i = 0; i<input.length(); i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine(), "");
            String temp = String.valueOf(input.charAt(i)).toUpperCase();

            for(int j = 0; j < alphabet.length; j++) {
                if(temp.equals(alphabet[j])) {
                    count[j]++;
                    break;
                }
            }
        }

        // 최대값 구함
        Integer maxValue = Arrays.stream(count)
                .max()
                .orElseThrow(NoSuchElementException::new);

        // 최대값에 대응되는 문자 구함
        String output = "?";
        for(int i = 0; i< count.length; i++) {
            if(count[i] ==maxValue && output!="?"){
                output = "?";
                break;
            }
            else if(count[i] == maxValue) {
                output = alphabet[i];
            }
        }

        System.out.println(output);

        //        bw.flush(); // stream을 flush 함. 프로세스를 닫지 않고 용량제어시 사용
//        bw.close();  // stream을 flush 하고, stream을 닫음
    }
}

