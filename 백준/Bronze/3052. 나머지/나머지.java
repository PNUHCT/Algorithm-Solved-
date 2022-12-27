import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<10 ; i++) {
            int temp = Integer.parseInt(br.readLine());
            if(!list.contains(temp%42)) list.add(temp%42);
        }
        System.out.println(list.size());
    }
}