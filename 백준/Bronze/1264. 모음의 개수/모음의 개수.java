import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Character> charList = new ArrayList<>();
        charList.add('a');charList.add('e');charList.add('i');charList.add('o');charList.add('u');
        charList.add('A');charList.add('E');charList.add('I');charList.add('O');charList.add('U');
        
        while(true) {
            String st = br.readLine();
            if(st.equals("#")) break;
            int cnt = 0;
            for(int i=0 ; i<st.length() ; i++) if(charList.contains(st.charAt(i))) cnt++;

            bw.write(""+cnt+"\n");
        }
        bw.close();
    }
}