import java.io.*;
import java.util.*;
 
public class Main{
 
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String boom = br.readLine();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            sb.append(ch);
            if(sb.length() >= boom.length()) {    // sb의 길이가 boom 이상이 되면 확인
                boolean sameFlag=true;
                for(int j=0; j<boom.length(); j++) {
                    char ch1 = sb.charAt(sb.length() - boom.length() + j);
                    char ch2 = boom.charAt(j);
                    if(ch1 != ch2) {
                        sameFlag = false;
                        break;
                    }
                }
                if(sameFlag) {
                    // 폭발 문자열 삭제
                    sb.delete(sb.length()-boom.length(), sb.length());
                }
            }
            
        }
        
        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
 